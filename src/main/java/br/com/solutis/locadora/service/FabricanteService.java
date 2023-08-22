package br.com.solutis.locadora.service;

import br.com.solutis.locadora.model.entity.FabricanteEntity;
import br.com.solutis.locadora.model.form.FabricanteInsertForm;
import br.com.solutis.locadora.repository.FabricanteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class FabricanteService implements BaseCrudService<FabricanteEntity, FabricanteEntity, FabricanteInsertForm> {

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
    public void salvar(FabricanteInsertForm form) {
        FabricanteEntity fabricante = new FabricanteEntity();
        fabricante.setNome(form.getNome());
        this.fabricanteRepository.save(fabricante);
    }

    @Override
    public void excluirPorId(Long id) {
        this.fabricanteRepository.deleteById(id);
    }
}
