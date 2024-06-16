package br.edu.imepac.administrative.controller;

import br.edu.imepac.commons.dto.EspecialidadeDTO;
import br.edu.imepac.administrative.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping
    public List<EspecialidadeDTO> getAllEspecialidades() {
        return especialidadeService.getAllEspecialidades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeDTO> getEspecialidadeById(@PathVariable Long id) {
        Optional<EspecialidadeDTO> especialidadeDTO = especialidadeService.getEspecialidadeById(id);
        return especialidadeDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EspecialidadeDTO> createEspecialidade(@RequestBody EspecialidadeDTO especialidadeDTO) {
        EspecialidadeDTO createdEspecialidade = especialidadeService.createEspecialidade(especialidadeDTO);
        return ResponseEntity.ok(createdEspecialidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadeDTO> updateEspecialidade(@PathVariable Long id, @RequestBody EspecialidadeDTO especialidadeDTO) {
        Optional<EspecialidadeDTO> updatedEspecialidade = especialidadeService.updateEspecialidade(id, especialidadeDTO);
        return updatedEspecialidade.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialidade(@PathVariable Long id) {
        especialidadeService.deleteEspecialidade(id);
        return ResponseEntity.noContent().build();
    }
}