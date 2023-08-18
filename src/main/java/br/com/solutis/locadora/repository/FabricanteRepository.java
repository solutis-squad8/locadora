package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.entity.FabricanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<FabricanteEntity, Long> {
}
