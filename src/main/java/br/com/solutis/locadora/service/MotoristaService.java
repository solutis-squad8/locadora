package br.com.solutis.locadora.service;

import br.com.solutis.locadora.model.entity.MotoristaEntity;
import br.com.solutis.locadora.repository.MotoristaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class MotoristaService extends BaseCrudService<MotoristaEntity> {
    @Autowired
    private MotoristaRepository motoristaRepository;

    @Override
    public MotoristaEntity salvar(MotoristaEntity motorista) {
        try{
            MotoristaEntity salvo = this.motoristaRepository.save(motorista);
            return salvo;
        }catch(DataIntegrityViolationException e){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "CPF já existente", e);
        }
    }

    @Override
    public MotoristaEntity obterPorId(Long id) {
        return this.motoristaRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<MotoristaEntity> obterTodos() {
        return this.motoristaRepository.findAll();
    }

    @Override
    public void excluirPorId(Long id) {
        this.motoristaRepository.deleteById(id);
    }


}
