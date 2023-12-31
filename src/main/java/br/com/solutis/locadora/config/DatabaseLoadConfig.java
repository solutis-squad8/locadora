package br.com.solutis.locadora.config;

import br.com.solutis.locadora.model.entity.*;
import br.com.solutis.locadora.model.entity.enums.CategoriaEntity;
import br.com.solutis.locadora.model.entity.enums.SexoEntity;
import br.com.solutis.locadora.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class DatabaseLoadConfig {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private MotoristaRepository motoristaRepository;
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private AcessorioRepository acessorioRepository;
    @Autowired
    private ModeloCarroRepository modeloCarroRepository;
    @Autowired
    private FabricanteRepository fabricanteRepository;
    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;
    @Autowired
    private AluguelRepository aluguelRepository;

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            List<AcessorioEntity> acessorioEntities = cargaInicialAcessorios();
            List<FabricanteEntity> fabricanteEntities = cargaInicialFabricante();
            List<ModeloCarroEntity> modeloCarroEntities = cargaInicialModeloCarro(fabricanteEntities);

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
            carro.setPlaca("ABC1234");
            carro.setCor("Azul");
            carro.setChassi("534764");
            carro.setValorDiaria(new BigDecimal(123.0));
            carro.adicionarAcessorio(acessorioEntities.get(1));
            carro.adicionarAcessorio(acessorioEntities.get(2));
            carro.setModelo(modeloCarroEntities.get(0));
            carroRepository.save(carro);

            CarroEntity carro2 = new CarroEntity();
            carro2.setPlaca("DEF5678");
            carro2.setCor("Vermelho");
            carro2.setChassi("5345432");
            carro2.setValorDiaria(new BigDecimal(100.0));
            carro2.adicionarAcessorio(acessorioEntities.get(0));
            carro2.adicionarAcessorio(acessorioEntities.get(3));
            carro2.setModelo(modeloCarroEntities.get(1));
            carroRepository.save(carro2);

            ApoliceSeguroEntity apolice = new ApoliceSeguroEntity(new BigDecimal(120), false, false, false);
            apoliceSeguroRepository.save(apolice);

            AluguelEntity aluguel = new AluguelEntity();
            aluguel.setCarro(carro);
            aluguel.setDataDevolucao(new Date());
            aluguel.setDataEntrega(new Date());
            aluguel.setApolice(apolice);
            aluguel.setValorTotal(new BigDecimal(125));
            aluguel.setMotorista(motorista);
            Calendar c = Calendar.getInstance();
            aluguel.setDataPedido(c);
            aluguelRepository.save(aluguel);
            apolice.setAluguel(aluguel);
            apoliceSeguroRepository.save(apolice);
        };
    }

    private List<AcessorioEntity> cargaInicialAcessorios() {
        return Arrays.asList("Ar-condicionado",
                "Sistema de navegação",
                "Difusor de escape",
                "Camera de ré",
                "Bancos de couro").stream().map(acessorio -> {
            AcessorioEntity acessorioEntity = new AcessorioEntity();
            acessorioEntity.setDescricao(acessorio);
            return acessorioRepository.save(acessorioEntity);
        }).collect(Collectors.toList());
    }

    private List<ModeloCarroEntity> cargaInicialModeloCarro(List<FabricanteEntity> fabricante) {
        return Arrays.asList("Picape",
                "Utilitario").stream().map(modeloCarro -> {
            ModeloCarroEntity modeloCarroEntity = new ModeloCarroEntity();
            modeloCarroEntity.setDescricao(modeloCarro);
            if(modeloCarroEntity.getDescricao().equals("Picape")) {
                modeloCarroEntity.setCategoria(CategoriaEntity.ESPORTIVO);
                modeloCarroEntity.setFabricante(fabricante.get(1));
            }
            else {
                modeloCarroEntity.setCategoria(CategoriaEntity.MINIVAN);
                modeloCarroEntity.setFabricante(fabricante.get(0));
            }
            return modeloCarroRepository.save(modeloCarroEntity);
        }).collect(Collectors.toList());
    }

    private List<FabricanteEntity> cargaInicialFabricante() {
        return Arrays.asList("Honda",
                "Volkswagen").stream().map(fabricante -> {
            FabricanteEntity fabricanteEntity = new FabricanteEntity();
            fabricanteEntity.setNome(fabricante);
            return fabricanteRepository.save(fabricanteEntity);
        }).collect(Collectors.toList());
    }
}
