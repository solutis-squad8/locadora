package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.form.FabricanteInsertForm;
import br.com.solutis.locadora.service.FabricanteService;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;
    @PostMapping
    public ResponseEntity<?> addFabricante(@RequestBody FabricanteInsertForm acessorio) {
        fabricanteService.salvar(acessorio);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> obterTodos() {
        return ResponseEntity.ok().body(fabricanteService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterPorId(@PathVariable @Nullable @Positive Long id) {
        return ResponseEntity.ok().body(fabricanteService.obterPorId(id));
    }
}
