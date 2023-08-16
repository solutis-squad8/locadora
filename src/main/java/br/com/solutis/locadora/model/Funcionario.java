package br.com.solutis.locadora.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Funcionario extends Pessoa {

    private String matricula;
}
