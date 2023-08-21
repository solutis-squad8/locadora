package br.com.solutis.locadora.service;

import br.com.solutis.locadora.mapper.AluguelMapper;
import br.com.solutis.locadora.mapper.ApoliceSeguroMapper;
import br.com.solutis.locadora.model.dto.AluguelDto;
import br.com.solutis.locadora.model.entity.AluguelEntity;
import br.com.solutis.locadora.model.entity.ApoliceSeguroEntity;
import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.model.entity.MotoristaEntity;
import br.com.solutis.locadora.model.form.AluguelInsertForm;
import br.com.solutis.locadora.repository.AluguelRepository;
import br.com.solutis.locadora.repository.ApoliceSeguroRepository;
import br.com.solutis.locadora.repository.CarroRepository;
import br.com.solutis.locadora.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AluguelService implements BaseCrudService<AluguelEntity, AluguelDto, AluguelInsertForm> {
    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private MotoristaRepository motoristaRepository;
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    @Override
    public AluguelEntity obterPorId(Long id) {
        return aluguelRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<AluguelDto> obterTodos() {
        return AluguelMapper.convertEntitiesToDto(aluguelRepository.findAll());
    }

    @Override
    public void salvar(AluguelInsertForm form) {
        MotoristaEntity motorista = motoristaRepository.findById(form.getMotoristaId()).orElseThrow(NoSuchElementException::new);
        CarroEntity carro = carroRepository.findById(form.getCarroId()).orElseThrow(NoSuchElementException::new);

        ApoliceSeguroEntity apolice = ApoliceSeguroMapper.convertToApoliceEntity(form.getApolice());
        apoliceSeguroRepository.save(apolice);

        AluguelEntity aluguel = new AluguelEntity(form, carro, motorista, apolice);

        aluguelRepository.save(aluguel);
        apolice.setAluguel(aluguel);
        apoliceSeguroRepository.save(apolice);
    }

    @Override
    public void excluirPorId(Long id) {
        aluguelRepository.deleteById(id);
    }

    public List<AluguelDto> obterAluguelPorMotoristaId(Long id){
        return AluguelMapper.convertEntitiesToDto(aluguelRepository.findAluguelEntitiesByMotorista_Id(id));
    }
}
