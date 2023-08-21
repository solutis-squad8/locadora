package br.com.solutis.locadora.model.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Data
public class AluguelInsertForm {

    private Calendar dataPedido;
    private Date dataEntrega;
    private Date dataDevolucao;
    private BigDecimal valorTotal;
    private Long motoristaId;
    private ApoliceInsertForm apolice;
    private Long carroId;

}
