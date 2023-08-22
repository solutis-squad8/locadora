package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.form.AluguelInsertForm;
import br.com.solutis.locadora.service.AluguelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/aluguel")
@Tag(name="Aluguel Controller")
public class AluguelController {

    private final AluguelService aluguelService;


    @Operation(
            summary =  "Adiciona um aluguel"
    )
    @PostMapping
    @Transactional
    public ResponseEntity<?> addAluguel(@RequestBody AluguelInsertForm aluguelInsertForm){
        aluguelService.salvar(aluguelInsertForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary =  "Retorna os aluguéis de um motorista"
    )
    @GetMapping("/motorista/{id}")
    public ResponseEntity<?> obterAlugueisPorMotoristaId(@Nullable @Positive @PathVariable Long id){;
        return ResponseEntity.ok().body(aluguelService.obterAluguelPorMotoristaId(id));
    }

    @Operation(
            summary =  "Retorna todos os aluguéis cadastrados"
    )
    @GetMapping
    public ResponseEntity<?> obterTodos() {
        return ResponseEntity.ok().body(aluguelService.obterTodos());
    }
}
