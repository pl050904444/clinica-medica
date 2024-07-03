package br.edu.imepac.administrativo.controller;

import br.edu.imepac.commons.dto.MedicoDTO;
import br.edu.imepac.administrativo.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    @Autowired
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> getAllMedicos() {
        List<MedicoDTO> medicos = medicoService.getAllMedicos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> getMedicoById(@PathVariable("id") Long id) {
        MedicoDTO medico = medicoService.getMedicoById(id);
        if (medico != null) {
            return new ResponseEntity<>(medico, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> createMedico(@RequestBody MedicoDTO medicoDTO) {
        MedicoDTO createdMedico = medicoService.createMedico(medicoDTO);
        return new ResponseEntity<>(createdMedico, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> updateMedico(
            @PathVariable("id") Long id,
            @RequestBody MedicoDTO medicoDTO
    ) {
        MedicoDTO updatedMedico = medicoService.updateMedico(id, medicoDTO);
        if (updatedMedico != null) {
            return new ResponseEntity<>(updatedMedico, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable("id") Long id) {
        boolean deleted = medicoService.deleteMedico(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}