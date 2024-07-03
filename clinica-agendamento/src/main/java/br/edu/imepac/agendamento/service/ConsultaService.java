package br.edu.imepac.agendamento.service;


import br.edu.imepac.agendamento.dto.ConsultaDTO;
import br.edu.imepac.agendamento.model.ConsultaModel;
import br.edu.imepac.agendamento.repository.ConsultaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<ConsultaDTO> getAllConsultas() {
        return consultaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ConsultaDTO getConsultaById(Long id) {
        Optional<ConsultaModel> optionalConsulta = consultaRepository.findById(id);
        return optionalConsulta.map(this::convertToDTO).orElse(null);
    }

    public ConsultaDTO createConsulta(ConsultaDTO consultaDTO) {
        ConsultaModel consultaModel = new ConsultaModel();
        BeanUtils.copyProperties(consultaDTO, consultaModel);
        consultaModel = consultaRepository.save(consultaModel);
        return convertToDTO(consultaModel);
    }

    public ConsultaDTO updateConsulta(Long id, ConsultaDTO consultaDTO) {
        Optional<ConsultaModel> optionalConsulta = consultaRepository.findById(id);

        if (optionalConsulta.isPresent()) {
            ConsultaModel existingConsulta = optionalConsulta.get();
            BeanUtils.copyProperties(consultaDTO, existingConsulta);
            existingConsulta.setId(id); // Ensure ID remains unchanged
            existingConsulta = consultaRepository.save(existingConsulta);
            return convertToDTO(existingConsulta);
        } else {
            return null;
        }
    }

    public boolean deleteConsulta(Long id) {
        if (consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private ConsultaDTO convertToDTO(ConsultaModel consultaModel) {
        ConsultaDTO consultaDTO = new ConsultaDTO();
        BeanUtils.copyProperties(consultaModel, consultaDTO);
        return consultaDTO;
    }
}