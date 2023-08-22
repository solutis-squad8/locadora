package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.entity.enums.CategoriaEntity;
import br.com.solutis.locadora.model.form.CarroInsertForm;
import br.com.solutis.locadora.service.CarroService;
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

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/carro")
@Tag(name = "Carro Controller")
public class CarroController {

    private final CarroService carroService;

    @Operation(
            summary =  "Adiciona um carro passando um CarroInsertForm"
    )
    @PostMapping
    @Transactional
    public ResponseEntity<?> addCarro(@RequestBody CarroInsertForm carroInsertForm){
        carroService.salvar(carroInsertForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary =  "Lista todos os carros podendo ser paginado",
            description = "A paginação pode ser pelo número da página e pelo tamanho da página.\n Ambos os dados são dinâmicos."
    )
    @GetMapping
    public ResponseEntity<?> obterCarros(@Nullable @Positive @RequestParam Long page,
                                         @Nullable @Positive @RequestParam Long size){
        return ResponseEntity.ok().body(carroService.obterTodos(page, size));
    }

    @Operation(
            summary =  "Retorna um carro pelo ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> obterCarroPorId(@Nullable @Positive @PathVariable Long id ){
        return ResponseEntity.ok().body(carroService.obterCarroDtoPorId(id));
    }

    @Operation(
            summary =  "Atualiza um carro pelo ID passando um CarroInsertForm com os dados"
    )
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarCarro(@PathVariable @Nullable @Positive Long id, @RequestBody CarroInsertForm carroInsertForm) {
        carroService.atualizarCarro(id, carroInsertForm);
        return ResponseEntity.ok().build();
   }

    @Operation(
            summary =  "Lista os carros filtrados",
            description = "Podem ser aplicados os filtros de múltiplos acessórios, categoria e fabricante."
    )
    @GetMapping("/filtro")
    public ResponseEntity<?> obterCarrosComFiltro(@Nullable @RequestParam List<Long> acessoriosId, @Nullable @RequestParam CategoriaEntity categoria, @Nullable @RequestParam String fabricante) {
        return ResponseEntity.ok().body(carroService.obterCarrosFiltrados(acessoriosId, categoria, fabricante));
    }
}
