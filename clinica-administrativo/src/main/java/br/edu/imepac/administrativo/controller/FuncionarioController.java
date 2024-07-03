package br.edu.imepac.administrativo.controller;

import br.edu.imepac.commons.dto.FuncionarioDTO;
import br.edu.imepac.administrativo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> getAllFuncionarios() {
        List<FuncionarioDTO> funcionarios = funcionarioService.getAllFuncionarios();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> getFuncionarioById(@PathVariable("id") Long id) {
        FuncionarioDTO funcionario = funcionarioService.getFuncionarioById(id);
        if (funcionario != null) {
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> createFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO createdFuncionario = funcionarioService.createFuncionario(funcionarioDTO);
        return new ResponseEntity<>(createdFuncionario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> updateFuncionario(
            @PathVariable("id") Long id,
            @RequestBody FuncionarioDTO funcionarioDTO
    ) {
        FuncionarioDTO updatedFuncionario = funcionarioService.updateFuncionario(id, funcionarioDTO);
        if (updatedFuncionario != null) {
            return new ResponseEntity<>(updatedFuncionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable("id") Long id) {
        boolean deleted = funcionarioService.deleteFuncionario(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}