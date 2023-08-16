package br.com.solutis.locadora.config;

import br.com.solutis.locadora.model.entity.FuncionarioEntity;
import br.com.solutis.locadora.model.entity.enums.SexoEntity;
import br.com.solutis.locadora.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.util.Optional;

@Configuration
public class DatabaseLoadConfig {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            FuncionarioEntity funcionario = new FuncionarioEntity();
            funcionario.setMatricula("16099");
            funcionario.setCpf("11111111111");
            funcionario.setSexo(SexoEntity.MASCULINO);
            funcionario.setDataNascimento(new Timestamp(System.currentTimeMillis()));
            funcionario.setNome("Sono");
            funcionarioRepository.save(funcionario);

            Optional<FuncionarioEntity> func = funcionarioRepository.findById(1L);
            System.out.println(func);
        };
    }
}
