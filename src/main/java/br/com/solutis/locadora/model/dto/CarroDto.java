package br.com.solutis.locadora.model.dto;

import br.com.solutis.locadora.model.entity.AcessorioEntity;
import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.model.entity.ModeloCarroEntity;

import java.math.BigDecimal;
import java.util.List;

public class CarroDto{
    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private ModeloCarroEntity modelo;

    private BigDecimal valorDiaria;

    private List<AcessorioEntity> acessorioEntity;

    public CarroDto() {
    }

    public CarroDto(CarroEntity carroEntity) {
        this.id = carroEntity.getId();
        this.cor = carroEntity.getCor();
        this.chassi = carroEntity.getChassi();
        this.placa = carroEntity.getPlaca();
        this.modelo = carroEntity.getModelo();
        this.valorDiaria = carroEntity.getValorDiaria();
        this.acessorioEntity = carroEntity.getAcessorios();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModeloCarroEntity getModelo() {
        return modelo;
    }

    public void setModelo(ModeloCarroEntity modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public List<AcessorioEntity> getAcessorioEntity() {
        return acessorioEntity;
    }

    public void setAcessorioEntity(List<AcessorioEntity> acessorioEntity) {
        this.acessorioEntity = acessorioEntity;
    }
}
