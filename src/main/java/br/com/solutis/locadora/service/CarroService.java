package br.com.solutis.locadora.service;

import br.com.solutis.locadora.mapper.CarroMapper;
import br.com.solutis.locadora.model.dto.CarroDto;
import br.com.solutis.locadora.model.entity.CarroEntity;
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
public class CarroService implements BaseCrudService<CarroEntity, CarroDto , CarroInsertForm>{
    @Autowired
    private CarroRepository carroRepository;

    @Override
    public void salvar(CarroInsertForm form) {
        CarroEntity carro = new CarroEntity();
        carro.setCor(form.getCor());
        carro.setPlaca(form.getPlaca());
        carro.setValorDiaria(form.getValorDiaria());
        carro.setModelo(carroRepository.findModeloById(form.getModeloId()).orElseThrow(NoSuchElementException::new));
        carro.setAcessorios(form.getAcessorios());

        this.carroRepository.save(carro);
    }


    @Override
    public CarroEntity obterPorId(Long id) {
        return carroRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<CarroDto> obterTodos() {
        return CarroMapper.convertToCarroDtos(carroRepository.findAll());
    }


    public List<CarroDto> obterTodos(Long page, Long size) {
        int trueSize = size == null? 10 : size.intValue();
        System.out.println("page = "+ page+" - size = "+ size+" - trueSize = "+ trueSize);
        return page==null?  CarroMapper.convertToCarroDtos(carroRepository.findAll()) : CarroMapper.
                convertToCarroDtos(carroRepository.findAllWithPage(PageRequest.of(page.intValue(), trueSize)));
    }

    public CarroDto obterCarroPorId(Long id) {
        return CarroMapper.convertToCarroDto(carroRepository.findById(id)
                .orElseThrow(NoSuchElementException::new));
    }

    public void excluirPorId(Long id) {
        this.carroRepository.deleteById(id);
    }
}
