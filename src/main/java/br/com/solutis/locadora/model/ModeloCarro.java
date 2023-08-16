package br.com.solutis.locadora.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ModeloCarro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String descricao;

    private Categoria categoria;

    @OneToMany
    private List<Carro> carros;

    @OneToOne
    private Fabricante fabricante;
}
