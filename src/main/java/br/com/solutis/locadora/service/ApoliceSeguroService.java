package br.com.solutis.locadora.service;


import br.com.solutis.locadora.model.entity.ApoliceSeguroEntity;
import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.repository.ApoliceSeguroRepository;
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
public class ApoliceSeguroService implements BaseCrudService<ApoliceSeguroEntity>{
    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    @Override
    public void salvar(ApoliceSeguroEntity apolice) {
        try{
            this.apoliceSeguroRepository.save(apolice);
        }catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Apólice de seguro já registrado", e);
        }
    }

    @Override
    public ApoliceSeguroEntity obterPorId(Long id) {
        return this.apoliceSeguroRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Page<ApoliceSeguroEntity> obterTodos(Pageable paginacao) {
        return this.apoliceSeguroRepository.findAll(paginacao);
    }

    @Override
    public void excluirPorId(Long id) {
        this.apoliceSeguroRepository.deleteById(id);
    }
}
