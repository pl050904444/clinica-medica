package br.edu.imepac.administrativo.service;

import br.edu.imepac.commons.dto.ProntuarioDTO;
import br.edu.imepac.commons.model.ProntuarioModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProntuarioService {

    private List<ProntuarioModel> prontuarioRepository = new ArrayList<>();

    public List<ProntuarioDTO> getAllProntuarios() {
        return prontuarioRepository.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProntuarioDTO getProntuarioById(Long id) {
        Optional<ProntuarioModel> optionalProntuario = prontuarioRepository.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        return optionalProntuario.map(this::convertToDTO).orElse(null);
    }

    public ProntuarioDTO createProntuario(ProntuarioDTO prontuarioDTO) {
        ProntuarioModel prontuarioModel = new ProntuarioModel();
        BeanUtils.copyProperties(prontuarioDTO, prontuarioModel);
        prontuarioModel.setId(generateId()); // Replace with actual ID generation logic
        prontuarioRepository.add(prontuarioModel);
        return convertToDTO(prontuarioModel);
    }

    public ProntuarioDTO updateProntuario(Long id, ProntuarioDTO prontuarioDTO) {
        Optional<ProntuarioModel> optionalProntuario = prontuarioRepository.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (optionalProntuario.isPresent()) {
            ProntuarioModel existingProntuario = optionalProntuario.get();
            BeanUtils.copyProperties(prontuarioDTO, existingProntuario);
            existingProntuario.setId(id); // Ensure ID remains unchanged
            return convertToDTO(existingProntuario);
        } else {
            return null;
        }
    }

    public boolean deleteProntuario(Long id) {
        Optional<ProntuarioModel> optionalProntuario = prontuarioRepository.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (optionalProntuario.isPresent()) {
            prontuarioRepository.removeIf(p -> p.getId().equals(id));
            return true;
        } else {
            return false;
        }
    }

    private ProntuarioDTO convertToDTO(ProntuarioModel prontuarioModel) {
        ProntuarioDTO prontuarioDTO = new ProntuarioDTO();
        BeanUtils.copyProperties(prontuarioModel, prontuarioDTO);
        return prontuarioDTO;
    }

    private Long generateId() {
        return System.currentTimeMillis();
    }
}