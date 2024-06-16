package br.edu.imepac.controllers;


import br.edu.imepac.service.ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.imepac.dtos.ConvenioDTO;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/convenios")
public class ConvenioController {

    @Autowired
    private ConvenioService convenioService;

    @GetMapping
    public List<ConvenioDTO> getAllConvenios() {
        return convenioService.getAllConvenios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConvenioDTO> getConvenioById(@PathVariable Long id) {
        Optional<ConvenioDTO> convenioDTO = convenioService.getConvenioById(id);
        return convenioDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ConvenioDTO> createConvenio(@RequestBody ConvenioDTO convenioDTO) {
        ConvenioDTO createdConvenio = convenioService.createConvenio(convenioDTO);
        return ResponseEntity.ok(createdConvenio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConvenioDTO> updateConvenio(@PathVariable Long id, @RequestBody ConvenioDTO convenioDTO) {
        Optional<ConvenioDTO> updatedConvenio = convenioService.updateConvenio(id, convenioDTO);
        return updatedConvenio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConvenio(@PathVariable Long id) {
        convenioService.deleteConvenio(id);
        return ResponseEntity.noContent().build();
    }
}