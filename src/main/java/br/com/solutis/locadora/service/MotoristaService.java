package br.com.solutis.locadora.service;

import br.com.solutis.locadora.model.entity.MotoristaEntity;
import br.com.solutis.locadora.repository.MotoristaRepository;
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
public class MotoristaService implements BaseCrudService<MotoristaEntity> {
    @Autowired
    private MotoristaRepository motoristaRepository;

    @Override
    public void salvar(MotoristaEntity motorista) {
        try{
            this.motoristaRepository.save(motorista);
        }catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "CPF ou CNH já cadastrada", e);
        }
    }

    @Override
    public MotoristaEntity obterPorId(Long id) {
        return this.motoristaRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Page<MotoristaEntity> obterTodos(Pageable paginacao) {
        return this.motoristaRepository.findAll(paginacao);
    }

    @Override
    public void excluirPorId(Long id) {
        this.motoristaRepository.deleteById(id);
    }


}
