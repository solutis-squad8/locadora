package br.com.solutis.locadora.controller;


import br.com.solutis.locadora.service.BaseCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BaseCrudController<T> {
    private BaseCrudService service;

    public BaseCrudController(BaseCrudService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<T> salvar(@RequestBody T entity){
        return ResponseEntity.ok((T) service.salvar(entity));
    }
}
