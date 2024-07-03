package br.edu.imepac.administrativo.controller;

import br.edu.imepac.commons.dto.ConvenioDTO;
import br.edu.imepac.administrativo.service.ConvenioService;
import br.edu.imepac.commons.model.ConvenioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/convenios")
public class ConvenioController {

    private final ConvenioService convenioService;

    @Autowired
    public ConvenioController(ConvenioService convenioService) {
        this.convenioService = convenioService;
    }

    @GetMapping
    public ResponseEntity<List<ConvenioDTO>> getAllConvenios() {
        List<ConvenioDTO> convenios = convenioService.getAllConvenios();
        return new ResponseEntity<>(convenios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConvenioDTO> getConvenioById(@PathVariable("id") Long id) {
        ConvenioDTO convenio = convenioService.getConvenioById(id);
        if (convenio != null) {
            return new ResponseEntity<>(convenio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ConvenioDTO> createConvenio(@RequestBody ConvenioDTO convenioDTO) {
        ConvenioDTO createdConvenio = convenioService.createConvenio(convenioDTO);
        return new ResponseEntity<>(createdConvenio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConvenioDTO> updateConvenio(
            @PathVariable("id") Long id,
            @RequestBody ConvenioDTO convenioDTO
    ) {
        ConvenioDTO updatedConvenio = convenioService.updateConvenio(id, convenioDTO);
        if (updatedConvenio != null) {
            return new ResponseEntity<>(updatedConvenio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConvenio(@PathVariable("id") Long id) {
        boolean deleted = convenioService.deleteConvenio(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}