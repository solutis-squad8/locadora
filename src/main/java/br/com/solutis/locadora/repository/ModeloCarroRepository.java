package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.entity.ModeloCarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarroEntity, Long> {
}
