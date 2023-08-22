package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
}
