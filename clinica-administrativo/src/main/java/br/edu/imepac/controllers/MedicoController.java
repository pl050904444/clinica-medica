package br.edu.imepac.controllers;

import br.edu.imepac.models.MedicoModel;
import br.edu.imepac.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medico") //localhost://medico/****
public class MedicoController {
//request => controller => service => repository
    @Autowired
    private MedicoService medicoService;

  @GetMapping
    public String listDoctor(){
        return "Resource doctor called";

    }

    @PostMapping
    public MedicoModel saveDoctor(@RequestBody MedicoModel medico){
        return medicoService.save(medico);
    }

}
