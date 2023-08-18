package br.com.solutis.locadora.service;

import br.com.solutis.locadora.model.entity.AcessorioEntity;
import br.com.solutis.locadora.repository.AcessorioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



@Service
@Transactional
public class AcessorioService implements BaseCrudService<AcessorioEntity> {
    @Autowired
    private AcessorioRepository acessorioRepository;

    public void salvar(AcessorioEntity acessorio) {
        try{
            this.acessorioRepository.save(acessorio);
        }catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Acessórios já registrados", e);
        }
    }

    @Override
    public AcessorioEntity obterPorId(Long id) {
        return null;
    }

    @Override
    public Page<AcessorioEntity> obterTodos(Pageable paginacao) {
        return this.acessorioRepository.findAll(paginacao);
    }

    @Override
    public void excluirPorId(Long id) {
        this.acessorioRepository.deleteById(id);
    }

}
