package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.entity.ApoliceSeguroEntity;
import br.com.solutis.locadora.model.form.ApoliceInsertForm;
import br.com.solutis.locadora.service.ApoliceSeguroService;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/apoliceseguro")
public class ApoliceSeguroController {

    @Autowired
    private ApoliceSeguroService service;

    @PostMapping
    @Transactional
    public ResponseEntity<?> addApolice(@RequestBody ApoliceInsertForm apoliceInsertForm) {
        service.salvar(apoliceInsertForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterApolice(@PathVariable @Positive @Nullable Long id) {
        return ResponseEntity.ok().body(service.obterPorId(id));
    }

    @GetMapping
    public ResponseEntity<?> obterApolices(/*@Nullable @Positive @RequestParam Long page,@Nullable @Positive @RequestParam Long size*/){
        return ResponseEntity.ok().body(service.obterTodos(/*page, size*/));
    }

}
