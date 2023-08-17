package br.com.solutis.locadora.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseCrudService<T> {
    T obterPorId(Long id);
    Page<T> obterTodos(Pageable paginacao);
    void salvar(T entity);
    void excluirPorId(Long id);
}
