package br.edu.imepac.atendimento.service;

import br.edu.imepac.atendimento.dto.AtendimentoDTO;
import br.edu.imepac.atendimento.model.AtendimentoModel;
import br.edu.imepac.atendimento.repository.AtendimentoRepository;
import br.edu.imepac.commons.model.ConvenioModel;
import br.edu.imepac.commons.model.MedicoModel;
import br.edu.imepac.commons.model.PacienteModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    @Autowired
    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    public List<AtendimentoDTO> getAllAtendimentos() {
        return atendimentoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AtendimentoDTO getAtendimentoById(Long id) {
        Optional<AtendimentoModel> optionalAtendimento = atendimentoRepository.findById(id);
        return optionalAtendimento.map(this::convertToDTO).orElse(null);
    }

    public AtendimentoDTO createAtendimento(AtendimentoDTO atendimentoDTO) {
        AtendimentoModel atendimentoModel = new AtendimentoModel();
        copyProperties(atendimentoDTO, atendimentoModel);
        atendimentoModel = atendimentoRepository.save(atendimentoModel);
        return convertToDTO(atendimentoModel);
    }

    public AtendimentoDTO updateAtendimento(Long id, AtendimentoDTO atendimentoDTO) {
        Optional<AtendimentoModel> optionalAtendimento = atendimentoRepository.findById(id);

        if (optionalAtendimento.isPresent()) {
            AtendimentoModel existingAtendimento = optionalAtendimento.get();
            copyProperties(atendimentoDTO, existingAtendimento);
            existingAtendimento.setId(id); // Ensure ID remains unchanged
            existingAtendimento = atendimentoRepository.save(existingAtendimento);
            return convertToDTO(existingAtendimento);
        } else {
            return null;
        }
    }

    public boolean deleteAtendimento(Long id) {
        if (atendimentoRepository.existsById(id)) {
            atendimentoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private AtendimentoDTO convertToDTO(AtendimentoModel atendimentoModel) {
        AtendimentoDTO atendimentoDTO = new AtendimentoDTO();
        copyProperties(atendimentoModel, atendimentoDTO);
        return atendimentoDTO;
    }

    private void copyProperties(AtendimentoDTO source, AtendimentoModel target) {
        BeanUtils.copyProperties(source, target);
        // Manually set MedicoModel, PacienteModel, ConvenioModel if needed
        // Example:
        // target.setMedico(source.getMedico());
        // target.setPaciente(source.getPaciente());
        // target.setConvenio(source.getConvenio());
    }

    private void copyProperties(AtendimentoModel source, AtendimentoDTO target) {
        BeanUtils.copyProperties(source, target);
        // Manually set MedicoModel, PacienteModel, ConvenioModel if needed
        // Example:
        // target.setMedico(source.getMedico());
        // target.setPaciente(source.getPaciente());
        // target.setConvenio(source.getConvenio());
    }
}