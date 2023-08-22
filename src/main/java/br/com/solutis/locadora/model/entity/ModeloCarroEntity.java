package br.com.solutis.locadora.model.entity;


import br.com.solutis.locadora.model.entity.enums.CategoriaEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "modelo_carro")
public class ModeloCarroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String descricao;

    @Enumerated(EnumType.STRING)
    @NotNull
    private CategoriaEntity categoria;


    @ManyToOne
    @JoinTable(name = "fabricante_modelo", joinColumns = @JoinColumn(name = "modelo_id", foreignKey = @ForeignKey(name
            = "modelo_id_fk")), inverseJoinColumns = @JoinColumn(name = "fabricante_id", foreignKey = @ForeignKey(name
            = "fabricante_id_fk")))
    private FabricanteEntity fabricante;

    public ModeloCarroEntity(Long id, String descricao, CategoriaEntity categoria, FabricanteEntity fabricante){
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.fabricante = fabricante;
    }

    public ModeloCarroEntity() {

    }
}
