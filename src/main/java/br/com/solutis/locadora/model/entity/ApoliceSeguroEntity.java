package br.com.solutis.locadora.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "apolice_seguro")
public class ApoliceSeguroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private BigDecimal valorFranquia;

    @NotNull
    private Boolean protecaoTerceiro;

    @NotNull
    private Boolean protecaoCausasNaturais;

    @NotNull
    private Boolean protecaoRoubo;

    @OneToOne
    private AluguelEntity aluguel;
}
