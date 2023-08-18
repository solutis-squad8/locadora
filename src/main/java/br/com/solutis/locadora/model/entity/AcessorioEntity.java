package br.com.solutis.locadora.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "acessorio")
public class AcessorioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToMany(mappedBy = "acessorio")
    private List<CarroEntity> carros;
}
