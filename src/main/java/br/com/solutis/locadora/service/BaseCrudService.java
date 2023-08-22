package br.com.solutis.locadora.service;

import java.util.List;

public interface BaseCrudService<T, E, C> {
    T obterPorId(Long id);

    List<E> obterTodos();

    void salvar(C entity);

    void excluirPorId(Long id);
}
