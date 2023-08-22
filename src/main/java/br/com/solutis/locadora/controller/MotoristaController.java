package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.entity.CarrinhoEntity;
import br.com.solutis.locadora.model.entity.MotoristaEntity;
import br.com.solutis.locadora.service.CarrinhoService;
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
    @Autowired
    CarrinhoService carrinhoService;

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

    @GetMapping("/{id}/carrinho")
    public ResponseEntity<?> obterCarrinhoPorMotoristaId(@PathVariable @Positive Long id) {
        return ResponseEntity.ok().body(carrinhoService.listarCarrinho(id));
    }

    @PostMapping("/carrinho")
    public ResponseEntity<?> addItemAoCarrinho(@RequestBody CarrinhoEntity carrinho) {
        carrinhoService.addItemAoCarrinho(carrinho);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/carrinho/{id}")
    public ResponseEntity<?> removerItemDoCarrinho(@PathVariable @Positive Long id) {
        carrinhoService.removerItemDoCarrinho(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{id}/carrinho/finalizar")
    public ResponseEntity<?> finalizarCarrinho(@PathVariable Long id) {
        carrinhoService.finalizarCarrinho(id);
        return ResponseEntity.ok().build();
    }

}
