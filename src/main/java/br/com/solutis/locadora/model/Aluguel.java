package br.com.solutis.locadora.model;

import jakarta.persistence.*;
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

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataPedido;

    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;

    private BigDecimal valorTotal;

}