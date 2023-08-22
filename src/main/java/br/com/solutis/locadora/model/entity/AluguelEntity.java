package br.com.solutis.locadora.model.entity;

import br.com.solutis.locadora.model.form.AluguelInsertForm;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "aluguel")
public class AluguelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Calendar dataPedido;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    private Date dataEntrega;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    private Date dataDevolucao;

    @NotNull
    private BigDecimal valorTotal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "motorista_id", referencedColumnName = "id")
    private MotoristaEntity motorista;

    @NotNull
    @OneToOne
    @JoinColumn(name = "apoliceSeguro_id")
    private ApoliceSeguroEntity apolice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carro_id", referencedColumnName = "id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private CarroEntity carro;

    public AluguelEntity(AluguelInsertForm form, CarroEntity carro, MotoristaEntity motorista, ApoliceSeguroEntity apolice) {
        dataPedido = Calendar.getInstance();
        dataDevolucao = form.getDataDevolucao();
        dataEntrega = form.getDataEntrega();
        this.motorista = motorista;
        this.carro = carro;
        this.apolice = apolice;
        Long numeroDias = ChronoUnit.DAYS.between(dataEntrega.toInstant(), dataDevolucao.toInstant());
        valorTotal = new BigDecimal((carro.getValorDiaria().intValue() * numeroDias) + apolice.getValorFranquia().intValue());
    }

    public AluguelEntity(CarrinhoEntity carrinho, MotoristaEntity motorista, CarroEntity carro, ApoliceSeguroEntity apolice) {
        this.dataPedido = Calendar.getInstance();
        this.dataDevolucao = carrinho.getDataDevolucao();
        this.dataEntrega = carrinho.getDataEntrega();
        this.apolice = apolice;
        this.valorTotal = new BigDecimal((carro.getValorDiaria().intValue() *
                ChronoUnit.DAYS.between(dataEntrega.toInstant(), dataDevolucao.toInstant()) + apolice.getValorFranquia().intValue()));
        this.motorista = motorista;
        this.carro = carro;
    }
}