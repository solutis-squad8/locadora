package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.entity.MotoristaEntity;
import br.com.solutis.locadora.service.MotoristaService;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/motorista")
public class MotoristaController{
    @Autowired
    MotoristaService motoristaService;

    @GetMapping
    public ResponseEntity<?> obterTodos(@Nullable @Positive @RequestParam Long page, @Nullable @Positive @RequestParam Long size){
        return ResponseEntity.ok().body(motoristaService.obterTodos(page, size));
    }

    @PostMapping
    public ResponseEntity<?> addMotorista(@RequestBody MotoristaEntity form){
        motoristaService.salvar(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterPorId(@Positive @PathVariable Long id){
        return ResponseEntity.ok().body(motoristaService.obterPorId(id));
    }
}
