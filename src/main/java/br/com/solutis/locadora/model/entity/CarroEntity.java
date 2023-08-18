package br.com.solutis.locadora.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private Long Id;

    @Column(unique = true)
    @NotBlank
    private String placa;

    @NotBlank
    private String cor;

    @NotNull
    private BigDecimal valorDiaria;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "equipado", joinColumns = @JoinColumn(name = "carro_id", foreignKey = @ForeignKey(name
            = "equipado_carro_id_fk")), inverseJoinColumns = @JoinColumn(name = "acessorio_id", foreignKey = @ForeignKey(name
            = "equipado_acessorio_id_fk")))
    private List<AcessorioEntity> acessorios = new ArrayList<>();

    @OneToMany(mappedBy = "carro", fetch = FetchType.LAZY)
    private List<AluguelEntity> alugueis = new ArrayList<>();

    @OneToOne
    private ModeloCarroEntity modelo;

    public void adicionarAcessorio(AcessorioEntity acessorioEntity){
        acessorioEntity.getCarros().add(this);
        acessorios.add(acessorioEntity);
    }

    public void adicionarAcessorios(List<AcessorioEntity> acessorioEntities){
        for (AcessorioEntity acessorioEntity: acessorioEntities) {
            acessorioEntity.getCarros().add(this);
        }
        acessorios = acessorioEntities;
    }
}
