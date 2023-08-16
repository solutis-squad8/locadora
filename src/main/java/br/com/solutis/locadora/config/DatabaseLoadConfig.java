package br.com.solutis.locadora.config;

import br.com.solutis.locadora.model.Funcionario;
import br.com.solutis.locadora.model.Pessoa;
import br.com.solutis.locadora.model.Sexo;
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
            Funcionario funcionario = new Funcionario();
            funcionario.setMatricula("16099");
            funcionario.setCpf("11111111111");
            funcionario.setSexo(Sexo.MASCULINO);
            funcionario.setDataNascimento(new Timestamp(System.currentTimeMillis()));
            funcionario.setNome("Sono");
            funcionarioRepository.save(funcionario);

            Optional<Funcionario> func = funcionarioRepository.findById(1L);
            System.out.println(func);
        };
    }
}
