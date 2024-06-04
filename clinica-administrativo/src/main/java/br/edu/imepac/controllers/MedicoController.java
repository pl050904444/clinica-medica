package br.edu.imepac.controllers;

import br.edu.imepac.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Medico saveDoctor(){
      medicoService.save(medico)
    }

}
