package br.com.solutis.locadora.controller;


import br.com.solutis.locadora.service.BaseCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseCrudController<T> {
    private BaseCrudService service;

    public BaseCrudController(BaseCrudService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> obterporId(@PathVariable Long id){
        return ResponseEntity.ok((T) service.obterPorId(id));
    }
    @GetMapping
    public ResponseEntity<List<T>> obterTodos(){
       return ResponseEntity.ok( (List<T>) service.obterTodos());
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody T entity){
        service.salvar(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id){
        service.excluirPorId(id);
        return ResponseEntity.ok().build();
    }
}
