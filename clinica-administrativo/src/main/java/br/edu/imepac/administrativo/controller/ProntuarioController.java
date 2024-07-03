package br.edu.imepac.administrativo.controller;

import br.edu.imepac.commons.dto.ProntuarioDTO;
import br.edu.imepac.administrativo.service.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prontuarios")
public class ProntuarioController {

    private final ProntuarioService prontuarioService;

    @Autowired
    public ProntuarioController(ProntuarioService prontuarioService) {
        this.prontuarioService = prontuarioService;
    }

    @GetMapping
    public ResponseEntity<List<ProntuarioDTO>> getAllProntuarios() {
        List<ProntuarioDTO> prontuarios = prontuarioService.getAllProntuarios();
        return new ResponseEntity<>(prontuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioDTO> getProntuarioById(@PathVariable("id") Long id) {
        ProntuarioDTO prontuario = prontuarioService.getProntuarioById(id);
        if (prontuario != null) {
            return new ResponseEntity<>(prontuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ProntuarioDTO> createProntuario(@RequestBody ProntuarioDTO prontuarioDTO) {
        ProntuarioDTO createdProntuario = prontuarioService.createProntuario(prontuarioDTO);
        return new ResponseEntity<>(createdProntuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProntuarioDTO> updateProntuario(
            @PathVariable("id") Long id,
            @RequestBody ProntuarioDTO prontuarioDTO
    ) {
        ProntuarioDTO updatedProntuario = prontuarioService.updateProntuario(id, prontuarioDTO);
        if (updatedProntuario != null) {
            return new ResponseEntity<>(updatedProntuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProntuario(@PathVariable("id") Long id) {
        boolean deleted = prontuarioService.deleteProntuario(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}