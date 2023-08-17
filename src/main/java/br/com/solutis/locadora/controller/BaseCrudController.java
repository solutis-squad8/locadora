package br.com.solutis.locadora.controller;


import br.com.solutis.locadora.service.BaseCrudService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseCrudController<T> {
    private final BaseCrudService<T> service;

    public BaseCrudController(BaseCrudService<T> service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> obterporId(@PathVariable Long id){
        return ResponseEntity.ok(service.obterPorId(id));
    }
    @GetMapping
    public ResponseEntity<Page<T>> obterTodos(Pageable paginacao){
       return ResponseEntity.ok(service.obterTodos(paginacao));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<T> salvar(@RequestBody T entity){
        service.salvar(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<T> deletarPorId(@PathVariable Long id){
        service.excluirPorId(id);
        return ResponseEntity.ok().build();
    }
}
