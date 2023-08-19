package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.model.entity.ApoliceSeguroEntity;
import br.com.solutis.locadora.service.ApoliceSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apoliceseguro")
public class ApoliceSeguroController extends BaseCrudController<ApoliceSeguroEntity>{

    public ApoliceSeguroController(@Autowired ApoliceSeguroService service){
        super(service);
    }
}
