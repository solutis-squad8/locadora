package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.entity.MotoristaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<MotoristaEntity, Long> {
}
