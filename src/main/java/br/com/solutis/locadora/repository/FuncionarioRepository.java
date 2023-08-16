package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
}
