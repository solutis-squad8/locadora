package br.com.solutis.locadora.model.dto;

import br.com.solutis.locadora.model.entity.AluguelEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
public class AluguelDto {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "America/Sao_Paulo")
    private Calendar dataPedido;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    private Date dataEntrega;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    private Date dataDevolucao;
    private BigDecimal valorTotal;
    private MotoristaDto motorista;
    private ApoliceSeguroDto apolice;
    private CarroDto carro;

    public AluguelDto(AluguelEntity entity) {
        dataDevolucao = entity.getDataDevolucao();
        dataEntrega = entity.getDataEntrega();
        dataPedido = entity.getDataPedido();
        valorTotal = entity.getValorTotal();
        motorista = new MotoristaDto(entity.getMotorista());
        carro = new CarroDto(entity.getCarro());
        apolice = new ApoliceSeguroDto(entity.getApolice());
    }
}
