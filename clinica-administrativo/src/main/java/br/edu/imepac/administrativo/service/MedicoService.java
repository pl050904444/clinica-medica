package br.edu.imepac.administrativo.service;

import br.edu.imepac.commons.dto.MedicoDTO;
import br.edu.imepac.commons.model.MedicoModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    private List<MedicoModel> medicoRepository = new ArrayList<>();

    public List<MedicoDTO> getAllMedicos() {
        return medicoRepository.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MedicoDTO getMedicoById(Long id) {
        Optional<MedicoModel> optionalMedico = medicoRepository.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();

        return optionalMedico.map(this::convertToDTO).orElse(null);
    }

    public MedicoDTO createMedico(MedicoDTO medicoDTO) {
        MedicoModel medicoModel = new MedicoModel();
        BeanUtils.copyProperties(medicoDTO, medicoModel);
        medicoModel.setId(generateId()); // Replace with actual ID generation logic
        medicoRepository.add(medicoModel);
        return convertToDTO(medicoModel);
    }

    public MedicoDTO updateMedico(Long id, MedicoDTO medicoDTO) {
        Optional<MedicoModel> optionalMedico = medicoRepository.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();

        if (optionalMedico.isPresent()) {
            MedicoModel existingMedico = optionalMedico.get();
            BeanUtils.copyProperties(medicoDTO, existingMedico);
            existingMedico.setId(id); // Ensure ID remains unchanged
            return convertToDTO(existingMedico);
        } else {
            return null;
        }
    }

    public boolean deleteMedico(Long id) {
        Optional<MedicoModel> optionalMedico = medicoRepository.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();

        if (optionalMedico.isPresent()) {
            medicoRepository.removeIf(m -> m.getId().equals(id));
            return true;
        } else {
            return false;
        }
    }

    private MedicoDTO convertToDTO(MedicoModel medicoModel) {
        MedicoDTO medicoDTO = new MedicoDTO();
        BeanUtils.copyProperties(medicoModel, medicoDTO);
        return medicoDTO;
    }

    private Long generateId() {
        return System.currentTimeMillis();
    }
}