package br.com.solutis.locadora.model;

import br.com.solutis.locadora.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class continuarAmanha {
        @Autowired
        private FuncionarioRepository funcionarioRepository;
        public void metodo(){
            Funcionario funcionario = new Funcionario();
            funcionario.setMatricula("16099");
            funcionario.setCpf("9845632355");
            funcionario.setSexo(Sexo.MASCULINO);
            funcionario.setDataNascimento(new Timestamp(System.currentTimeMillis()));
            funcionario.setNome("Sono");
            this.funcionarioRepository.save(funcionario);
        }
}
