package br.com.solutis.locadora.config;

import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.model.entity.FuncionarioEntity;
import br.com.solutis.locadora.model.entity.MotoristaEntity;
import br.com.solutis.locadora.model.entity.enums.SexoEntity;
import br.com.solutis.locadora.repository.FuncionarioRepository;
import br.com.solutis.locadora.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

@Configuration
public class DatabaseLoadConfig {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private MotoristaRepository motoristaRepository;

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

            MotoristaEntity motorista = new MotoristaEntity();
            motorista.setNumeroCNH("1111111111");
            motorista.setCpf("22222222222");
            motorista.setSexo(SexoEntity.MASCULINO);
            motorista.setDataNascimento(new Timestamp(System.currentTimeMillis()));
            motorista.setNome("Batata");
            motoristaRepository.save(motorista);

            CarroEntity carro = new CarroEntity();

        };
    }
}
