package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.form.AcessorioInsertForm;
import br.com.solutis.locadora.service.AcessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/acessorio")
public class AcessorioController {

    @Autowired
    AcessorioService acessorioService;

    @PostMapping
    public ResponseEntity<?> addAcessorio(@RequestBody AcessorioInsertForm form){
        acessorioService.salvar(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> obterTodos(){
        return ResponseEntity.ok().body(acessorioService.obterTodos());
    }

}
