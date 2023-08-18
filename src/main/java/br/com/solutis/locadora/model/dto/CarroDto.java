package br.com.solutis.locadora.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

public record CarroDto(String placa,
                       String cor,
                       BigDecimal valorDiaria) {
}
