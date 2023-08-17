package br.com.solutis.locadora.service;

import java.util.List;

public interface BaseCrudService<T> {
    T obterPorId(Long id);
    List<T> obterTodos();
    void salvar(T entity);
    void excluirPorId(Long id);
}
