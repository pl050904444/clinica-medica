package br.edu.imepac.controllers;

import br.edu.imepac.dtos.FuncionarioDTO;
import br.edu.imepac.administrative.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioDTO> getAllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> getFuncionarioById(@PathVariable Long id) {
        Optional<FuncionarioDTO> funcionarioDTO = funcionarioService.getFuncionarioById(id);
        return funcionarioDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> createFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO createdFuncionario = funcionarioService.createFuncionario(funcionarioDTO);
        return ResponseEntity.ok(createdFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> updateFuncionario(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
        Optional<FuncionarioDTO> updatedFuncionario = funcionarioService.updateFuncionario(id, funcionarioDTO);
        return updatedFuncionario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        funcionarioService.deleteFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}