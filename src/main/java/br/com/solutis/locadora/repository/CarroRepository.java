package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.entity.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<CarroEntity, Long> {

}
