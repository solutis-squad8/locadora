package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.entity.MotoristaEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MotoristaRepository extends JpaRepository<MotoristaEntity, Long> {

    @Query(value = "SELECT new MotoristaEntity(id, nome, dataNascimento, cpf, sexo, numeroCNH) from MotoristaEntity")
    List<MotoristaEntity> findAllWithPage(Pageable pageable);
}
