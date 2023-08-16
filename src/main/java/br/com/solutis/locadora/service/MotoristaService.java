package br.com.solutis.locadora.service;

import br.com.solutis.locadora.model.entity.MotoristaEntity;
import br.com.solutis.locadora.repository.MotoristaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MotoristaService extends BaseCrudService<MotoristaEntity> {
    @Autowired
    private MotoristaRepository motoristaRepository;

    @Override
    public MotoristaEntity salvar(MotoristaEntity motorista) {
        return this.motoristaRepository.save(motorista);
    }

    @Override
    public MotoristaEntity obterPorId(Long id) {
        return this.motoristaRepository.findById(id)
                .orElseThrow(RuntimeException::new);
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
