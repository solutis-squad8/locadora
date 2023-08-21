package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.repository.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modelo")
public class ModeloController {
    @Autowired
    private ModeloCarroRepository modeloCarroRepository;
    @GetMapping
    public ResponseEntity<?> obterTodos(){
        return ResponseEntity.ok().body(modeloCarroRepository.findAll());
    }
}
