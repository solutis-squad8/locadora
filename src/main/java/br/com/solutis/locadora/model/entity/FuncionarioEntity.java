package br.com.solutis.locadora.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "funcionario")
public class FuncionarioEntity extends PessoaEntity {

    @NotBlank
    private String matricula;
}
