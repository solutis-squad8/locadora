package br.com.solutis.locadora.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Funcionario extends Pessoa {

    @NotBlank
    private String matricula;
}
