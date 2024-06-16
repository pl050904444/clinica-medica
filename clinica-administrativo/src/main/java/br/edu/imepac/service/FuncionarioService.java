package br.edu.imepac.administrative.service;

import br.edu.imepac.commons.dto.FuncionarioDTO;
import br.edu.imepac.commons.model.FuncionarioModel;
import br.edu.imepac.commons.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> getAllFuncionarios() {
        return funcionarioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<FuncionarioDTO> getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id)
                .map(this::convertToDTO);
    }

    public FuncionarioDTO createFuncionario(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionarioModel = convertToEntity(funcionarioDTO);
        FuncionarioModel savedFuncionario = funcionarioRepository.save(funcionarioModel);
        return convertToDTO(savedFuncionario);
    }

    public Optional<FuncionarioDTO> updateFuncionario(Long id, FuncionarioDTO funcionarioDTO) {
        return funcionarioRepository.findById(id)
                .map(existingFuncionario -> {
                    existingFuncionario.setNome(funcionarioDTO.getNome());
                    existingFuncionario.setCpf(funcionarioDTO.getCpf());
                    existingFuncionario.setCargo(funcionarioDTO.getCargo());
                    FuncionarioModel updatedFuncionario = funcionarioRepository.save(existingFuncionario);
                    return convertToDTO(updatedFuncionario);
                });
    }

    public void deleteFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

    private FuncionarioDTO convertToDTO(FuncionarioModel funcionarioModel) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setId(funcionarioModel.getId());
        funcionarioDTO.setNome(funcionarioModel.getNome());
        funcionarioDTO.setCpf(funcionarioModel.getCpf());
        funcionarioDTO.setCargo(funcionarioModel.getCargo());
        return funcionarioDTO;
    }

    private FuncionarioModel convertToEntity(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioModel.setId(funcionarioDTO.getId());
        funcionarioModel.setNome(funcionarioDTO.getNome());
        funcionarioModel.setCpf(funcionarioDTO.getCpf());
        funcionarioModel.setCargo(funcionarioDTO.getCargo());
        return funcionarioModel;
    }
}