package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.service.CarroService;
import br.com.solutis.locadora.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carro")
public class CarroController extends BaseCrudController<CarroEntity> {
    public CarroController(@Autowired CarroService service){
        super(service);
    }
}
