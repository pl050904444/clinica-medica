package br.edu.imepac.controllers;

import br.edu.imepac.models.ConvenioModel;
import br.edu.imepac.services.ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {

    @Autowired
    private ConvenioService convenioService;

    @PostMapping
    public ConvenioModel saveConvenio(@RequestBody ConvenioModel convenio) {
        return convenioService.save(convenio);
    }

    @GetMapping
    public List<ConvenioModel> listConvenios() {
        return convenioService.getAllConvenios();
    }

    @GetMapping("/{id}")
    public Optional<ConvenioModel> getConvenioById(@PathVariable Long id) {
        return convenioService.getConvenioById(id);
    }

    @PutMapping("/{id}")
    public ConvenioModel updateConvenio(@PathVariable Long id, @RequestBody ConvenioModel updatedConvenio) {
        return convenioService.updateConvenio(id, updatedConvenio);
    }

    @DeleteMapping("/{id}")
    public void deleteConvenio(@PathVariable Long id) {
        convenioService.deleteConvenio(id);
    }
}