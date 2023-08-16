package br.com.solutis.locadora.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class ApoliceSeguro {
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
    private Aluguel aluguel;
}
