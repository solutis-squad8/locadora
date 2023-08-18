package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.entity.AcessorioEntity;
import br.com.solutis.locadora.service.AcessorioService;
import br.com.solutis.locadora.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acessorio")
public class AcessorioController extends BaseCrudController<AcessorioEntity> {
    public AcessorioController(@Autowired AcessorioService service){
        super(service);
    }
}
