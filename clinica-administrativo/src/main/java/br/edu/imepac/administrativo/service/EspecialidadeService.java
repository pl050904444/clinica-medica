package br.edu.imepac.administrativo.service;

import br.edu.imepac.commons.dto.EspecialidadeDTO;
import br.edu.imepac.commons.model.EspecialidadeModel;
import br.edu.imepac.commons.repository.EspecialidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;

    @Autowired
    public EspecialidadeService(EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }

    public List<EspecialidadeDTO> getAllEspecialidades() {
        List<EspecialidadeModel> especialidadeModels = especialidadeRepository.findAll();
        return especialidadeModels.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public EspecialidadeDTO getEspecialidadeById(Long id) {
        Optional<EspecialidadeModel> especialidadeOptional = especialidadeRepository.findById(id);
        return especialidadeOptional.map(this::convertToDto).orElse(null);
    }

    public EspecialidadeDTO createEspecialidade(EspecialidadeDTO especialidadeDTO) {
        EspecialidadeModel especialidadeModel = convertToEntity(especialidadeDTO);
        EspecialidadeModel savedEspecialidade = especialidadeRepository.save(especialidadeModel);
        return convertToDto(savedEspecialidade);
    }

    public EspecialidadeDTO updateEspecialidade(Long id, EspecialidadeDTO especialidadeDTO) {
        Optional<EspecialidadeModel> optionalEspecialidade = especialidadeRepository.findById(id);
        if (optionalEspecialidade.isPresent()) {
            EspecialidadeModel existingEspecialidade = optionalEspecialidade.get();
            BeanUtils.copyProperties(especialidadeDTO, existingEspecialidade, "id"); // Copy non-null properties from DTO to existing entity
            EspecialidadeModel updatedEspecialidade = especialidadeRepository.save(existingEspecialidade);
            return convertToDto(updatedEspecialidade);
        } else {
            return null;
        }
    }

    public boolean deleteEspecialidade(Long id) {
        if (especialidadeRepository.existsById(id)) {
            especialidadeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private EspecialidadeDTO convertToDto(EspecialidadeModel especialidadeModel) {
        EspecialidadeDTO especialidadeDTO = new EspecialidadeDTO();
        BeanUtils.copyProperties(especialidadeModel, especialidadeDTO);
        return especialidadeDTO;
    }

    private EspecialidadeModel convertToEntity(EspecialidadeDTO especialidadeDTO) {
        EspecialidadeModel especialidadeModel = new EspecialidadeModel();
        BeanUtils.copyProperties(especialidadeDTO, especialidadeModel);
        return especialidadeModel;
    }
}