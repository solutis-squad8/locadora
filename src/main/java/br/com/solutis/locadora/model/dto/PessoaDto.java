package br.com.solutis.locadora.model.dto;

import br.com.solutis.locadora.model.entity.enums.SexoEntity;

import java.util.Date;

public record PessoaDto(String nome, Date dataNascimento, String cpf, SexoEntity sexo) {
}
