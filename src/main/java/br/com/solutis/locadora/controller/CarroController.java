package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.form.CarroInsertForm;
import br.com.solutis.locadora.service.CarroService;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/carro")
public class CarroController {

    private final CarroService carroService;

    @PostMapping
    public ResponseEntity<?> addCarro(@RequestBody CarroInsertForm carroInsertForm){
        carroService.salvar(carroInsertForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> obterCarros(@Nullable @Positive @RequestParam Long page,@Nullable @Positive @RequestParam Long size){
        return ResponseEntity.ok().body(carroService.obterTodos(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterCarroPorId(@Nullable @Positive @PathVariable Long id ){
        return ResponseEntity.ok().body(carroService.obterCarroPorId(id));
    }
}
