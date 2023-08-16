package br.com.solutis.locadora.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Motorista extends Pessoa {

    private String numeroCNH;
}
