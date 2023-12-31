package br.com.solutis.locadora.model.entity;


import br.com.solutis.locadora.model.form.ApoliceInsertForm;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "apolice_seguro")
public class ApoliceSeguroEntity {
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
    private AluguelEntity aluguel;

    public ApoliceSeguroEntity(ApoliceInsertForm form) {
        valorFranquia = form.getValorFranquia();
        protecaoTerceiro = form.getProtecaoTerceiro();
        protecaoCausasNaturais = form.getProtecaoCausasNaturais();
        protecaoRoubo = form.getProtecaoRoubo();
    }

    public ApoliceSeguroEntity(BigDecimal valorFranquia, Boolean protecaoTerceiro, Boolean protecaoCausasNaturais, Boolean protecaoRoubo) {
        this.valorFranquia = valorFranquia;
        this.protecaoTerceiro = protecaoTerceiro;
        this.protecaoCausasNaturais = protecaoCausasNaturais;
        this.protecaoRoubo = protecaoRoubo;
    }

    public ApoliceSeguroEntity() {

    }
}
