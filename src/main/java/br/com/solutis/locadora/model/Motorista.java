package br.com.solutis.locadora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Motorista extends Pessoa {

    @NotBlank
    @Pattern(regexp = "\\d{10}")
    private String numeroCNH;

    @OneToMany
    private List<Aluguel> alugueis;
}
