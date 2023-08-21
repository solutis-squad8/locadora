package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.model.entity.enums.CategoriaEntity;
import br.com.solutis.locadora.model.form.CarroInsertForm;
import br.com.solutis.locadora.service.CarroService;
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
@RequestMapping("/carro")
public class CarroController {

    private final CarroService carroService;

    @PostMapping
    @Transactional
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
        return ResponseEntity.ok().body(carroService.obterCarroDtoPorId(id));
    }

    @GetMapping("/fabricante/{id}")
    public ResponseEntity<?> obterCarroPorFabricante(@Nullable @Positive @PathVariable Long id) {
        return ResponseEntity.ok().body(carroService.obterCarrosPorFabricante(id));
    }

    @GetMapping("categoria/{categoria}")
    public ResponseEntity<?> obterCarroPorCategoria(@PathVariable CategoriaEntity categoria) {
        return ResponseEntity.ok().body(carroService.obterCarrosPorCategoria(categoria));
    }

    @GetMapping("acessorio/{acessorio}")
    public ResponseEntity<?> obterCarroPorAcessorio(@PathVariable String acessorio) {
        return null;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarCarro(@PathVariable @Nullable @Positive Long id, @RequestBody CarroInsertForm carroInsertForm) {
        carroService.atualizarCarro(id, carroInsertForm);
        return ResponseEntity.ok().build();
   }


}
