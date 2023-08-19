package br.com.solutis.locadora.model.dto;

import br.com.solutis.locadora.model.entity.AcessorioEntity;
import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.model.entity.FabricanteEntity;
import br.com.solutis.locadora.model.entity.ModeloCarroEntity;
import br.com.solutis.locadora.model.entity.enums.CategoriaEntity;

import java.math.BigDecimal;

public class CarroMinDto {
    private String placa;
    private String cor;
    private BigDecimal valorDiaria;


    public CarroMinDto(CarroEntity carro){
        this.placa = carro.getPlaca();
        this.cor = carro.getCor();
        this.valorDiaria = carro.getValorDiaria();
    }

    public CarroMinDto() {
    }

}
