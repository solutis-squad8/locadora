package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.repository.ModeloCarroRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modelo")
@Tag(name="Modelo do Carro Controller")
public class ModeloController {
    @Autowired
    private ModeloCarroRepository modeloCarroRepository;
    @Operation(
            summary =  "Lista todos os modelos de carro cadastrados"
    )
    @GetMapping
    public ResponseEntity<?> obterTodos(){
        return ResponseEntity.ok().body(modeloCarroRepository.findAll());
    }
}
