package br.edu.imepac.administrativo.service;

import br.edu.imepac.commons.dto.PacienteDTO;
import br.edu.imepac.commons.model.PacienteModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private List<PacienteModel> pacienteRepository = new ArrayList<>();

    public List<PacienteDTO> getAllPacientes() {
        return pacienteRepository.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PacienteDTO getPacienteById(Long id) {
        Optional<PacienteModel> optionalPaciente = pacienteRepository.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        return optionalPaciente.map(this::convertToDTO).orElse(null);
    }

    public PacienteDTO createPaciente(PacienteDTO pacienteDTO) {
        PacienteModel pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDTO, pacienteModel);
        pacienteModel.setId(generateId()); // Replace with actual ID generation logic
        pacienteRepository.add(pacienteModel);
        return convertToDTO(pacienteModel);
    }

    public PacienteDTO updatePaciente(Long id, PacienteDTO pacienteDTO) {
        Optional<PacienteModel> optionalPaciente = pacienteRepository.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (optionalPaciente.isPresent()) {
            PacienteModel existingPaciente = optionalPaciente.get();
            BeanUtils.copyProperties(pacienteDTO, existingPaciente);
            existingPaciente.setId(id); // Ensure ID remains unchanged
            return convertToDTO(existingPaciente);
        } else {
            return null;
        }
    }

    public boolean deletePaciente(Long id) {
        Optional<PacienteModel> optionalPaciente = pacienteRepository.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (optionalPaciente.isPresent()) {
            pacienteRepository.removeIf(p -> p.getId().equals(id));
            return true;
        } else {
            return false;
        }
    }

    private PacienteDTO convertToDTO(PacienteModel pacienteModel) {
        PacienteDTO pacienteDTO = new PacienteDTO();
        BeanUtils.copyProperties(pacienteModel, pacienteDTO);
        return pacienteDTO;
    }

    private Long generateId() {
        return System.currentTimeMillis();
    }
}