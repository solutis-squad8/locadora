package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.form.AcessorioInsertForm;
import br.com.solutis.locadora.service.AcessorioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/acessorio")
@Tag(name="Acessório Controller")
public class AcessorioController {

    @Autowired
    AcessorioService acessorioService;

    @Operation(
            summary =  "Adiciona um acessórios"
    )
    @PostMapping
    public ResponseEntity<?> addAcessorio(@RequestBody AcessorioInsertForm form){
        acessorioService.salvar(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @Operation(
            summary =  "Lista todos os acessórios"
    )
    @GetMapping
    public ResponseEntity<?> obterTodos(){
        return ResponseEntity.ok().body(acessorioService.obterTodos());
    }

}
