package br.com.solutis.locadora.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class ApoliceSeguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private BigDecimal valorFranquia;

    private Boolean protecaoTerceiro;

    private Boolean protecaoCausasNaturais;

    private Boolean protecaoRoubo;

    @OneToOne(mappedBy = "apoliceSeguro")
    private Aluguel aluguel;
}
