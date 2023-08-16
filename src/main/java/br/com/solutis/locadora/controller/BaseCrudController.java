package br.com.solutis.locadora.controller;


import br.com.solutis.locadora.service.BaseCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public abstract class BaseCrudController<T> {
    private BaseCrudService service;

    public BaseCrudController(BaseCrudService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> obterTodos(){
       return ResponseEntity.ok( (List<T>) service.obterTodos());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<T> salvar(@RequestBody T entity){
        return ResponseEntity.ok((T) service.salvar(entity));
    }
}
