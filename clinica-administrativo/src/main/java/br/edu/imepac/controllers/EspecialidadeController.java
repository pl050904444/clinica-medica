package br.edu.imepac.controllers;

import br.edu.imepac.models.EspecialidadeModel;
import br.edu.imepac.services.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/especialidade")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @PostMapping
    public EspecialidadeModel saveEspecialidade(@RequestBody EspecialidadeModel especialidade) {
        return especialidadeService.save(especialidade);
    }

    @GetMapping
    public List<EspecialidadeModel> listEspecialidades() {
        return especialidadeService.getAllEspecialidades();
    }

    @GetMapping("/{id}")
    public Optional<EspecialidadeModel> getEspecialidadeById(@PathVariable Long id) {
        return especialidadeService.getEspecialidadeById(id);
    }

    @PutMapping("/{id}")
    public EspecialidadeModel updateEspecialidade(@PathVariable Long id, @RequestBody EspecialidadeModel updatedEspecialidade) {
        return especialidadeService.updateEspecialidade(id, updatedEspecialidade);
    }

    @DeleteMapping("/{id}")
    public void deleteEspecialidade(@PathVariable Long id) {
        especialidadeService.deleteEspecialidade(id);
    }
}