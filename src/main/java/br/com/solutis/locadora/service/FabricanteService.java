package br.com.solutis.locadora.service;

import br.com.solutis.locadora.model.entity.FabricanteEntity;
import br.com.solutis.locadora.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FabricanteService implements BaseCrudService<FabricanteEntity, FabricanteEntity, FabricanteEntity> {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public FabricanteEntity obterPorId(Long id) {
        return fabricanteRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<FabricanteEntity> obterTodos() {
        return fabricanteRepository.findAll();
    }

    @Override
    public void salvar(FabricanteEntity entity) {
        this.fabricanteRepository.save(entity);
    }

    @Override
    public void excluirPorId(Long id) {
        this.fabricanteRepository.deleteById(id);
    }
}
