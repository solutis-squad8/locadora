package br.com.solutis.locadora.model.dto;

import br.com.solutis.locadora.model.entity.AcessorioEntity;
import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.model.entity.ModeloCarroEntity;

import java.math.BigDecimal;
import java.util.List;

public class CarroMinDto {

    private Long id;

    private ModeloCarroEntity modelo;
    private BigDecimal valorDiaria;
    private List<AcessorioEntity> acessorios;


    public CarroMinDto(CarroEntity carroEntity) {
        this.id = carroEntity.getId();
        this.modelo = carroEntity.getModelo();
        this.valorDiaria = carroEntity.getValorDiaria();
        this.acessorios = carroEntity.getAcessorios();
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

    public List<AcessorioEntity> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<AcessorioEntity> acessorios) {
        this.acessorios = acessorios;
    }
}
