package br.com.solutis.locadora.service;

import java.util.List;

public abstract class BaseCrudService<T> {
    public abstract T obterPorId(Long id);
    public abstract List<T> obterTodos();
    public abstract void salvar(T entity);
    public abstract void excluirPorId(Long id);
}
