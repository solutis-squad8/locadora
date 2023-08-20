package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.entity.AluguelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<AluguelEntity, Long> {
}