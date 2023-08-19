package br.com.solutis.locadora.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "fabricante")
public class FabricanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    private String nome;

    public FabricanteEntity(String nome){
        this.nome = nome;
    }

    public FabricanteEntity(){

    }
}
