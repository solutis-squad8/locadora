package br.com.solutis.locadora.model.entity;

import br.com.solutis.locadora.model.entity.enums.SexoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public abstract class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataNascimento;

    @Column(unique = true)
    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String cpf;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SexoEntity sexo;

}
