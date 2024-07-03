package br.edu.imepac.administrativo.controller;

import br.edu.imepac.commons.dto.PacienteDTO;
import br.edu.imepac.administrativo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {
        List<PacienteDTO> pacientes = pacienteService.getAllPacientes();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getPacienteById(@PathVariable("id") Long id) {
        PacienteDTO paciente = pacienteService.getPacienteById(id);
        if (paciente != null) {
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> createPaciente(@RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO createdPaciente = pacienteService.createPaciente(pacienteDTO);
        return new ResponseEntity<>(createdPaciente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> updatePaciente(
            @PathVariable("id") Long id,
            @RequestBody PacienteDTO pacienteDTO
    ) {
        PacienteDTO updatedPaciente = pacienteService.updatePaciente(id, pacienteDTO);
        if (updatedPaciente != null) {
            return new ResponseEntity<>(updatedPaciente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable("id") Long id) {
        boolean deleted = pacienteService.deletePaciente(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}