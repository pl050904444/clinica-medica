package br.edu.imepac.administrativo.controller;

import br.edu.imepac.commons.dto.MedicoDTO;
import br.edu.imepac.administrativo.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/medicos")
public class MedicoThymeleafController {

    private final MedicoService medicoService;

    @Autowired
    public MedicoThymeleafController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public String getAllMedicos(Model model) {
        List<MedicoDTO> medicos = medicoService.getAllMedicos();
        model.addAttribute("medicos", medicos);
        return "medicos/list";
    }
}