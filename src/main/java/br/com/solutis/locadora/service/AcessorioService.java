package br.com.solutis.locadora.service;

import br.com.solutis.locadora.model.entity.AcessorioEntity;
import br.com.solutis.locadora.model.form.AcessorioInsertForm;
import br.com.solutis.locadora.repository.AcessorioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class AcessorioService implements BaseCrudService<AcessorioEntity, AcessorioEntity, AcessorioInsertForm>{
    @Autowired
    private AcessorioRepository acessorioRepository;

    public void salvar(AcessorioInsertForm acessorioForm) {
        AcessorioEntity acessorioEntity = new AcessorioEntity(acessorioForm.getDescricao());

        this.acessorioRepository.save(acessorioEntity);
    }

    public AcessorioEntity obterPorId(Long id) {
        return null;
    }

    @Override
    public List<AcessorioEntity> obterTodos() {
        return acessorioRepository.findAll();
    }

    public void excluirPorId(Long id) {
        this.acessorioRepository.deleteById(id);
    }

}
