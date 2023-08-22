package br.com.solutis.locadora.service;

import br.com.solutis.locadora.mapper.CarroMapper;
import br.com.solutis.locadora.model.dto.CarroDto;
import br.com.solutis.locadora.model.dto.CarroMinDto;
import br.com.solutis.locadora.model.entity.AcessorioEntity;
import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.model.entity.ModeloCarroEntity;
import br.com.solutis.locadora.model.entity.enums.CategoriaEntity;
import br.com.solutis.locadora.model.form.CarroInsertForm;
import br.com.solutis.locadora.repository.CarroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public void salvar(CarroInsertForm form) {
        CarroEntity carro = new CarroEntity();
        carro.setCor(form.getCor());
        carro.setPlaca(form.getPlaca());
        carro.setValorDiaria(form.getValorDiaria());
        carro.setChassi(form.getChassi());
        carro.setModelo(carroRepository.findModeloById(form.getModeloId()).orElseThrow(NoSuchElementException::new));
        carro.setAcessorios(form.getAcessorios());

        this.carroRepository.save(carro);
    }

    public List<CarroMinDto> obterTodos(Long page, Long size) {
        int trueSize = size == null? 10 : size.intValue();
        System.out.println("page = "+ page+" - size = "+ size+" - trueSize = "+ trueSize);
        return page==null?  CarroMapper.convertToCarroMinDtos(carroRepository.findAll()) : CarroMapper.
                convertToCarroMinDtos(carroRepository.findAllWithPage(PageRequest.of(page.intValue(), trueSize)));
    }

    public CarroDto obterCarroDtoPorId(Long id) {
        return CarroMapper.convertToCarroDto(carroRepository.findById(id)
                .orElseThrow(NoSuchElementException::new));
    }

    public List<CarroDto> obterCarrosPorFabricante(Long id) {
        return CarroMapper.convertToCarroDtos(carroRepository.findCarroEntitiesByModelo_Fabricante_Id(id));
    }

    public List<CarroDto> obterCarrosPorCategoria(CategoriaEntity categoria) {
        return CarroMapper.convertToCarroDtos(carroRepository.findCarroEntitiesByModelo_Categoria(categoria));
    }

    public List<CarroDto> obterCarrosPorModeloId(Long id) {
        return CarroMapper.convertToCarroDtos(carroRepository.findCarroEntitiesByModelo_Id(id));
    }

    public void atualizarCarro(Long id, CarroInsertForm carroInsertForm) {
        CarroEntity carro = carroRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (carroInsertForm.getChassi() != null) {
            carro.setChassi(carroInsertForm.getChassi());
        }
        if (carroInsertForm.getCor() != null) {
            carro.setCor(carroInsertForm.getCor());
        }
        if (carroInsertForm.getValorDiaria() != null) {
            carro.setValorDiaria(carroInsertForm.getValorDiaria());
        }

    }

    public void excluirPorId(Long id) {
        this.carroRepository.deleteById(id);
    }
}
