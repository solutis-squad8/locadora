package br.com.solutis.locadora;

import br.com.solutis.locadora.model.Funcionario;
import br.com.solutis.locadora.model.Sexo;
import br.com.solutis.locadora.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class LocadoraApplication {

    private  FuncionarioRepository funcionarioRepository;
    public LocadoraApplication(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(LocadoraApplication.class, args);

    }

}
