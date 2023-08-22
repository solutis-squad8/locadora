package br.com.solutis.locadora.model.dto;

import br.com.solutis.locadora.model.entity.MotoristaEntity;
import br.com.solutis.locadora.model.entity.enums.SexoEntity;
import lombok.Data;

import java.util.Date;

@Data
public class MotoristaDto{
    private Long id;

    private String nome;

    private Date dataNascimento;

    private String cpf;

    private SexoEntity sexo;

    private String cnh;

    public MotoristaDto() {
    }

    public MotoristaDto(MotoristaEntity motorista) {
        this.id = motorista.getId();
        this.nome = motorista.getNome() ;
        this.dataNascimento = motorista.getDataNascimento();
        this.sexo = motorista.getSexo();
        this.cpf = motorista.getCpf();
        this.cnh = motorista.getNumeroCNH();
    }
}
