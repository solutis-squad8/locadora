package br.com.solutis.locadora.model.entity;

import br.com.solutis.locadora.model.entity.enums.SexoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "motorista")
public class MotoristaEntity extends PessoaEntity {

    @Column(unique=true)
    @NotBlank
    @Pattern(regexp = "\\d{10}")
    private String numeroCNH;

    @OneToMany
    private List<AluguelEntity> alugueis;

    MotoristaEntity(Long id, String nome, Timestamp dataNascimento, String cpf, SexoEntity sexo, String numeroCNH){
        this.setId(id);
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setCpf(cpf);
        this.setSexo(sexo);
        this.numeroCNH = numeroCNH;
    }

}
