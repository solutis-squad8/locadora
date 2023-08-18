package br.com.solutis.locadora.service;

import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.repository.CarroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Service
@Transactional
public class CarroService implements BaseCrudService<CarroEntity> {
    @Autowired
    private CarroRepository carroRepository;

    @Override
    public void salvar(CarroEntity carro) {
        try{
            this.carroRepository.save(carro);
        }catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Carro já registrado", e);
        }
    }

    @Override
    public CarroEntity obterPorId(Long id) {
        return this.carroRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Page<CarroEntity> obterTodos(Pageable paginacao) {
        return this.carroRepository.findAll(paginacao);
    }

    @Override
    public void excluirPorId(Long id) {
        this.carroRepository.deleteById(id);
    }
}
