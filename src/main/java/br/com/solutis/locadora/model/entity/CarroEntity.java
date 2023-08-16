package br.com.solutis.locadora.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "carro")
public class CarroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    private String placa;

    @NotBlank
    private String cor;

    @NotNull
    private BigDecimal valorDiaria;

    @OneToMany
    private List<AcessorioEntity> acessorios;

    @OneToMany
    private List<AluguelEntity> alugueis;

    @OneToOne
    private ModeloCarroEntity modelo;
}
