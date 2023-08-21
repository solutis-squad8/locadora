package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.dto.CarroDto;
import br.com.solutis.locadora.model.entity.AcessorioEntity;
import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.model.entity.ModeloCarroEntity;
import br.com.solutis.locadora.model.entity.enums.CategoriaEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarroRepository extends JpaRepository<CarroEntity, Long> {

    @Query(value = "SELECT new CarroEntity(id, placa, chassi, cor, valorDiaria, acessorios, alugueis, modelo) from CarroEntity ")
    List<CarroEntity> findAllWithPage(Pageable pageable);

    @Query("Select new ModeloCarroEntity(M.id, M.descricao, M.categoria, M.fabricante) " +
            " from ModeloCarroEntity M " +
            " where M.id = :id")
    Optional<ModeloCarroEntity> findModeloById(Long id);

    @Query("Select new CarroEntity(c.id, c.modelo, c.valorDiaria, c.acessorios) " +
            " from CarroEntity c")
    Optional<List<CarroDto>> getAllCarroDTO();

    List<CarroEntity> findCarroEntitiesByModelo_Fabricante_Id(Long id);

    List<CarroEntity> findCarroEntitiesByModelo_Categoria(CategoriaEntity categoria);

    List<CarroEntity> findCarroEntitiesByModelo_Id(Long id);

    List<CarroEntity> findCarroEntitiesByAcessoriosIn(List<AcessorioEntity> acessorios);
}
