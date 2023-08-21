package br.com.solutis.locadora.model.entity;


import br.com.solutis.locadora.model.form.CarroInsertForm;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "carro")
public class CarroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank
    private String placa;

    @NotBlank
    private String cor;

    @NotNull
    private BigDecimal valorDiaria;

    @NotNull
    private String chassi;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "equipado", joinColumns = @JoinColumn(name = "carro_id", foreignKey = @ForeignKey(name
            = "equipado_carro_id_fk")), inverseJoinColumns = @JoinColumn(name = "acessorio_id", foreignKey = @ForeignKey(name
            = "equipado_acessorio_id_fk")))
    private List<AcessorioEntity> acessorios = new ArrayList<>();

    @OneToMany(mappedBy = "carro", fetch = FetchType.LAZY)
    private List<AluguelEntity> alugueis = new ArrayList<>();

    @ManyToOne
    private ModeloCarroEntity modelo;

    public CarroEntity(CarroInsertForm form, ModeloCarroEntity modelo){
        this.placa = form.getPlaca();
        this.cor = form.getCor();
        this.valorDiaria = form.getValorDiaria();
        this.chassi = form.getChassi();
        this.modelo = modelo;
    }

    public CarroEntity(Long id, String placa, String chassi, String cor, BigDecimal valorDiaria, List<AcessorioEntity> acessorios, List<AluguelEntity> alugueis, ModeloCarroEntity modelo) {
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.valorDiaria = valorDiaria;
        this.acessorios = acessorios;
        this.alugueis = alugueis;
        this.modelo = modelo;
    }

    public CarroEntity(Long id,  ModeloCarroEntity modelo, BigDecimal valorDiaria, List<AcessorioEntity> acessorios) {
        this.id = id;
        this.valorDiaria = valorDiaria;
        this.acessorios = acessorios;
        this.modelo = modelo;
    }

    public void adicionarAcessorio(AcessorioEntity acessorioEntity){
        acessorios.add(acessorioEntity);
    }

    public void adicionarAcessorios(List<AcessorioEntity> acessorioEntityEntities){
        acessorios = acessorioEntityEntities;
    }
}
