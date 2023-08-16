package br.com.solutis.locadora.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "motorista")
public class MotoristaEntity extends PessoaEntity {

    @Column(unique=true)
    @NotBlank
    @Pattern(regexp = "\\d{10}")
    private String numeroCNH;

    @OneToMany
    private List<AluguelEntity> alugueis;
}
