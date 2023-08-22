package br.com.solutis.locadora.model.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Data
public class AluguelInsertForm {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    private Date dataEntrega;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    private Date dataDevolucao;
    private BigDecimal valorTotal;
    private Long motoristaId;
    private ApoliceInsertForm apolice;
    private Long carroId;

}
