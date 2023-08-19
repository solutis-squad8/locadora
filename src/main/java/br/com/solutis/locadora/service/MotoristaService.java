package br.com.solutis.locadora.service;

import br.com.solutis.locadora.mapper.MotoristaMapper;
import br.com.solutis.locadora.model.dto.MotoristaDto;
import br.com.solutis.locadora.model.entity.MotoristaEntity;
import br.com.solutis.locadora.repository.MotoristaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class MotoristaService implements BaseCrudService<MotoristaEntity, MotoristaDto, MotoristaEntity> {
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
    public List<MotoristaDto> obterTodos() {
        return MotoristaMapper.convertToMotoristaDtos(motoristaRepository.findAll());
    }

    public List<MotoristaDto> obterTodos(Long page, Long size) {
        int defaultSize = size == null ? 10 : size.intValue();
        return page == null ? MotoristaMapper.convertToMotoristaDtos(motoristaRepository.findAll())
                : MotoristaMapper.convertToMotoristaDtos(motoristaRepository.findAllWithPage(PageRequest.of(page.intValue(), defaultSize)));
    }

    @Override
    public void excluirPorId(Long id) {
        this.motoristaRepository.deleteById(id);
    }


}
