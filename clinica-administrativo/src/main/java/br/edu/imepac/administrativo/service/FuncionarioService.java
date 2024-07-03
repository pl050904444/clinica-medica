package br.edu.imepac.administrativo.service;

import br.edu.imepac.commons.dto.FuncionarioDTO;
import br.edu.imepac.commons.model.FuncionarioModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private List<FuncionarioModel> funcionarioRepository = new ArrayList<>();

    public List<FuncionarioDTO> getAllFuncionarios() {
        return funcionarioRepository.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FuncionarioDTO getFuncionarioById(Long id) {
        Optional<FuncionarioModel> optionalFuncionario = funcionarioRepository.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();

        return optionalFuncionario.map(this::convertToDTO).orElse(null);
    }

    public FuncionarioDTO createFuncionario(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        BeanUtils.copyProperties(funcionarioDTO, funcionarioModel);
        funcionarioModel.setId(generateId()); // Replace with actual ID generation logic
        funcionarioRepository.add(funcionarioModel);
        return convertToDTO(funcionarioModel);
    }

    public FuncionarioDTO updateFuncionario(Long id, FuncionarioDTO funcionarioDTO) {
        Optional<FuncionarioModel> optionalFuncionario = funcionarioRepository.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();

        if (optionalFuncionario.isPresent()) {
            FuncionarioModel existingFuncionario = optionalFuncionario.get();
            BeanUtils.copyProperties(funcionarioDTO, existingFuncionario);
            existingFuncionario.setId(id); // Ensure ID remains unchanged
            return convertToDTO(existingFuncionario);
        } else {
            return null;
        }
    }

    public boolean deleteFuncionario(Long id) {
        Optional<FuncionarioModel> optionalFuncionario = funcionarioRepository.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();

        if (optionalFuncionario.isPresent()) {
            funcionarioRepository.removeIf(f -> f.getId().equals(id));
            return true;
        } else {
            return false;
        }
    }

    private FuncionarioDTO convertToDTO(FuncionarioModel funcionarioModel) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        BeanUtils.copyProperties(funcionarioModel, funcionarioDTO);
        return funcionarioDTO;
    }

    private Long generateId() {
        return System.currentTimeMillis();
    }
}