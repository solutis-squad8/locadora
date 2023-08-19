package br.com.solutis.locadora.model.form;

import br.com.solutis.locadora.model.entity.AcessorioEntity;
import br.com.solutis.locadora.model.entity.AluguelEntity;
import br.com.solutis.locadora.model.entity.ModeloCarroEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarroInsertForm {

    @NotBlank
    private String placa;

    @NotBlank
    private String cor;

    @NotNull
    private BigDecimal valorDiaria;

    private List<AcessorioEntity> acessorios = new ArrayList<>();

    private Long modeloId;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public List<AcessorioEntity> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<AcessorioEntity> acessorios) {
        this.acessorios = acessorios;
    }

    public Long getModeloId() {
        return modeloId;
    }

    public void setModeloId(Long modeloId) {
        this.modeloId = modeloId;
    }
}
