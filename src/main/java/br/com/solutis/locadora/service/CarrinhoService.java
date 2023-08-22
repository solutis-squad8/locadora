package br.com.solutis.locadora.service;

import br.com.solutis.locadora.model.entity.*;
import br.com.solutis.locadora.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private MotoristaRepository motoristaRepository;
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    public void addItemAoCarrinho(CarrinhoEntity carrinho) {
        if (carrinho.getDataEntrega().before(carrinho.getDataDevolucao())) {
            List<AluguelEntity> search = aluguelRepository.findAluguelEntitiesByCarro_Id(carrinho.getCarroId());
            for (AluguelEntity aluguel :
                    search) {
                if (!disponibilidadeCarroAluguel(carrinho.getDataEntrega(), carrinho.getDataDevolucao(),
                        aluguel.getDataEntrega(), aluguel.getDataDevolucao())) {
                    throw new DataIntegrityViolationException("Aluguel já existente para as datas selecionadas!");
                }
            }
            carrinhoRepository.save(carrinho);
            return;
        }
        throw new DataIntegrityViolationException("Data de entrega deve ser menor que data de devolução!");
    }

    public void removerItemDoCarrinho(Long carrinhoId) {
        CarrinhoEntity carrinho = carrinhoRepository.findById(carrinhoId).orElseThrow(NoSuchElementException::new);
        carrinhoRepository.delete(carrinho);
    }

    public List<CarrinhoEntity> listarCarrinho(Long motoristaId) {
        MotoristaEntity motorista = motoristaRepository.findById(motoristaId).orElseThrow(NoSuchElementException::new);
        return carrinhoRepository.findAllByMotoristaId(motorista.getId());
    }

    public void finalizarCarrinho(Long motoristaId) {
        MotoristaEntity motorista = motoristaRepository.findById(motoristaId).orElseThrow(NoSuchElementException::new);
        List<CarrinhoEntity> listaCarrinho = carrinhoRepository.findAllByMotoristaId(motorista.getId());
        CarroEntity carro;
        List<AluguelEntity> aluguel = new ArrayList<>();
        AluguelEntity aluguelEntity;
        ApoliceSeguroEntity apoliceSeguroEntity;
        for (CarrinhoEntity carrinho : listaCarrinho) {
            carro = carroRepository.findById(carrinho.getCarroId()).get();
            apoliceSeguroEntity = new ApoliceSeguroEntity(carrinho.getValorApolice(),
                    carrinho.getProtecaoTerceiro(), carrinho.getProtecaoCausasNaturais(), carrinho.getProtecaoRoubo());
            apoliceSeguroRepository.save(apoliceSeguroEntity);
            aluguelEntity = new AluguelEntity(carrinho, motorista, carro, apoliceSeguroEntity);
            aluguel.add(aluguelEntity);
            aluguelRepository.save(aluguelEntity);
            carrinhoRepository.delete(carrinho);
        }
    }

    public boolean disponibilidadeCarroAluguel(Date formEntrega, Date formDevolucao, Date searchEntrega, Date
            searchDevolucao) {
        if (formEntrega.before(searchEntrega) && formDevolucao.after(searchEntrega) ||
                formEntrega.before(searchEntrega) && formDevolucao.after(searchDevolucao) ||
                formEntrega.before(searchDevolucao) && formDevolucao.after(searchDevolucao) ||
                formEntrega.after(searchEntrega) && formDevolucao.before(searchDevolucao) ||
                formEntrega.equals(searchEntrega) && formDevolucao.equals(searchDevolucao)) {
            return false;
        }
        return true;
    }
}

