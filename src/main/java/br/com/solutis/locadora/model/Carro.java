package br.com.solutis.locadora.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    private String placa;

    @NotBlank
    private String cor;

    @NotNull
    private BigDecimal valorDiaria;

    @ManyToMany
    private List<Acessorio> acessorio;

    @OneToMany
    private List<Aluguel> alugueis;

    @OneToOne
    private ModeloCarro modeloCarro;
}
