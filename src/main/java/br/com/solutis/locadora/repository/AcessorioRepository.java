package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.entity.AcessorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessorioRepository extends JpaRepository<AcessorioEntity, Long> {
}
