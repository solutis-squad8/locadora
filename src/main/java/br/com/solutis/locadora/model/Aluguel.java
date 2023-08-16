package br.com.solutis.locadora.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataPedido;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;

    @NotNull
    private BigDecimal valorTotal;

    @NotNull
    @OneToOne
    private Motorista motorista;

    @NotNull
    @OneToOne
    @JoinColumn(name = "apolice_seguro_id")
    private ApoliceSeguro apoliceSeguro;

    @OneToOne
    private Carro carro;

}