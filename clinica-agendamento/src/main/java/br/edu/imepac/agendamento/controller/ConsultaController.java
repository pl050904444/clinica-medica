package br.edu.imepac.agendamento.controller;

import br.edu.imepac.agendamento.dto.ConsultaDTO;
import br.edu.imepac.agendamento.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> getAllConsultas() {
        List<ConsultaDTO> consultas = consultaService.getAllConsultas();
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> getConsultaById(@PathVariable("id") Long id) {
        ConsultaDTO consulta = consultaService.getConsultaById(id);
        if (consulta != null) {
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ConsultaDTO> createConsulta(@RequestBody ConsultaDTO consultaDTO) {
        ConsultaDTO createdConsulta = consultaService.createConsulta(consultaDTO);
        return new ResponseEntity<>(createdConsulta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> updateConsulta(
            @PathVariable("id") Long id,
            @RequestBody ConsultaDTO consultaDTO
    ) {
        ConsultaDTO updatedConsulta = consultaService.updateConsulta(id, consultaDTO);
        if (updatedConsulta != null) {
            return new ResponseEntity<>(updatedConsulta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }//l
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable("id") Long id) {
        boolean deleted = consultaService.deleteConsulta(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}