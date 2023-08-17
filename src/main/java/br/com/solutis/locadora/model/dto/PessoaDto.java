package br.com.solutis.locadora.model.dto;

import br.com.solutis.locadora.model.entity.enums.SexoEntity;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record PessoaDto(@NotNull String nome,
                        Date dataNascimento,
                        String cpf,
                        SexoEntity sexo) {
}
