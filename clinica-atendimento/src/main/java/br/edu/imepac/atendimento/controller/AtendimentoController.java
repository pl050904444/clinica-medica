package br.edu.imepac.atendimento.controller;

import br.edu.imepac.atendimento.dto.AtendimentoDTO;
import br.edu.imepac.atendimento.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    @Autowired
    public AtendimentoController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoDTO>> getAllAtendimentos() {
        List<AtendimentoDTO> atendimentos = atendimentoService.getAllAtendimentos();
        return new ResponseEntity<>(atendimentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoDTO> getAtendimentoById(@PathVariable("id") Long id) {
        AtendimentoDTO atendimento = atendimentoService.getAtendimentoById(id);
        if (atendimento != null) {
            return new ResponseEntity<>(atendimento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AtendimentoDTO> createAtendimento(@RequestBody AtendimentoDTO atendimentoDTO) {
        AtendimentoDTO createdAtendimento = atendimentoService.createAtendimento(atendimentoDTO);
        return new ResponseEntity<>(createdAtendimento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtendimentoDTO> updateAtendimento(
            @PathVariable("id") Long id,
            @RequestBody AtendimentoDTO atendimentoDTO
    ) {
        AtendimentoDTO updatedAtendimento = atendimentoService.updateAtendimento(id, atendimentoDTO);
        if (updatedAtendimento != null) {
            return new ResponseEntity<>(updatedAtendimento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtendimento(@PathVariable("id") Long id) {
        boolean deleted = atendimentoService.deleteAtendimento(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}