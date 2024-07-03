package br.edu.imepac.administrativo.controller;

import br.edu.imepac.commons.dto.EspecialidadeDTO;
import br.edu.imepac.administrativo.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    @Autowired
    public EspecialidadeController(EspecialidadeService especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    @GetMapping
    public ResponseEntity<List<EspecialidadeDTO>> getAllEspecialidades() {
        List<EspecialidadeDTO> especialidades = especialidadeService.getAllEspecialidades();
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeDTO> getEspecialidadeById(@PathVariable("id") Long id) {
        EspecialidadeDTO especialidade = especialidadeService.getEspecialidadeById(id);
        if (especialidade != null) {
            return new ResponseEntity<>(especialidade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EspecialidadeDTO> createEspecialidade(@RequestBody EspecialidadeDTO especialidadeDTO) {
        EspecialidadeDTO createdEspecialidade = especialidadeService.createEspecialidade(especialidadeDTO);
        return new ResponseEntity<>(createdEspecialidade, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadeDTO> updateEspecialidade(
            @PathVariable("id") Long id,
            @RequestBody EspecialidadeDTO especialidadeDTO
    ) {
        EspecialidadeDTO updatedEspecialidade = especialidadeService.updateEspecialidade(id, especialidadeDTO);
        if (updatedEspecialidade != null) {
            return new ResponseEntity<>(updatedEspecialidade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialidade(@PathVariable("id") Long id) {
        boolean deleted = especialidadeService.deleteEspecialidade(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}