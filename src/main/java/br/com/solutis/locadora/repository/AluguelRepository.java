package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.entity.AluguelEntity;
import br.com.solutis.locadora.model.entity.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AluguelRepository extends JpaRepository<AluguelEntity, Long> {
    List<AluguelEntity> findAluguelEntitiesByMotorista_Id(Long id);
}