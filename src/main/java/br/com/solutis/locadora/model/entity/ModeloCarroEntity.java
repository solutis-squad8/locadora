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

    @OneToMany
    private List<CarroEntity> carros;

    @OneToOne
    private FabricanteEntity fabricante;
}
