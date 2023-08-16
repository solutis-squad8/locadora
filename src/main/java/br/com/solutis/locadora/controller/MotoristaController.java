package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.Motorista;
import br.com.solutis.locadora.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/motorista")
public class MotoristaController extends BaseCrudController<Motorista>{
    public MotoristaController(@Autowired MotoristaService service){
        super(service);
    }
}
