package br.edu.imepac.commons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaInicial {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "World");
        return "index"; // This should resolve to src/main/resources/templates/index.html
    }
}