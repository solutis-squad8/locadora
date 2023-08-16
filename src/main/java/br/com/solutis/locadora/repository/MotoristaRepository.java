package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository  extends JpaRepository<Motorista,Long> {
}
