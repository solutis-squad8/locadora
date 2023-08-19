package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.dto.CarroDto;
import br.com.solutis.locadora.model.dto.CarroMinDto;
import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.model.entity.ModeloCarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarroRepository extends JpaRepository<CarroEntity, Long> {

    @Query(value = "SELECT new CarroEntity(id, placa, cor, valorDiaria, acessorios, alugueis, modelo) from CarroEntity ")
    List<CarroEntity> findAllWithPage(Pageable pageable);

    @Query("Select new ModeloCarroEntity(M.id, M.descricao, M.categoria, M.fabricante) " +
            " from ModeloCarroEntity M " +
            " where M.id = :id")
    Optional<ModeloCarroEntity> findModeloById(Long id);

    @Query("Select new CarroEntity(c.id, c.modelo, c.valorDiaria, c.acessorios) " +
            " from CarroEntity c")
    Optional<List<CarroDto>> getAllCarroDTO();
}
