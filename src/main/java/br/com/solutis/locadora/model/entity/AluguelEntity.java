package br.com.solutis.locadora.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@Table(name = "aluguel")
public class AluguelEntity {
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
    private MotoristaEntity motorista;

    @NotNull
    @OneToOne
    @JoinColumn(name = "apoliceSeguro_id")
    private ApoliceSeguroEntity apolice;

    @OneToOne
    private CarroEntity carro;

}