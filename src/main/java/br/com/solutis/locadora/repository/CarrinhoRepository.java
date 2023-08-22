package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.entity.CarrinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {
    List<CarrinhoEntity> findAllByMotoristaId(Long id);
}
