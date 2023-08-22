package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.entity.AluguelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AluguelRepository extends JpaRepository<AluguelEntity, Long> {
    List<AluguelEntity> findAluguelEntitiesByMotorista_Id(Long id);

    List<AluguelEntity> findAluguelEntitiesByDataEntregaGreaterThanEqualAndDataDevolucaoLessThanEqualAndCarro_Id(
            Date dataEntrega, Date dataDevolucao, Long carroId);

    List<AluguelEntity> findAluguelEntitiesByCarro_Id(Long carroId);
}