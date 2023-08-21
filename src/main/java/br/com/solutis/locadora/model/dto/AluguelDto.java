package br.com.solutis.locadora.model.dto;

import br.com.solutis.locadora.model.entity.AluguelEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
public class AluguelDto {
    private Calendar dataPedido;
    private Date dataEntrega;
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
