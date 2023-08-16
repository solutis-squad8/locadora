package br.com.solutis.locadora.service;

import br.com.solutis.locadora.model.Motorista;
import br.com.solutis.locadora.repository.MotoristaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MotoristaService extends BaseCrudService<Motorista> {
    @Autowired
    private MotoristaRepository motoristaRepository;

    @Override
    public Motorista salvar(Motorista motorista) {
        return this.motoristaRepository.save(motorista);
    }

    @Override
    public Motorista obterPorId(Long id) {
        return this.motoristaRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Motorista> obterTodos() {
        return this.motoristaRepository.findAll();
    }

    @Override
    public void excluirPorId(Long id) {
        this.motoristaRepository.deleteById(id);
    }


}
