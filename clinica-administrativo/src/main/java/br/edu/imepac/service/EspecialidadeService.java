package br.edu.imepac.administrative.service;

import br.edu.imepac.commons.dto.EspecialidadeDTO;
import br.edu.imepac.commons.model.EspecialidadeModel;
import br.edu.imepac.commons.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public List<EspecialidadeDTO> getAllEspecialidades() {
        return especialidadeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<EspecialidadeDTO> getEspecialidadeById(Long id) {
        return especialidadeRepository.findById(id)
                .map(this::convertToDTO);
    }

    public EspecialidadeDTO createEspecialidade(EspecialidadeDTO especialidadeDTO) {
        EspecialidadeModel especialidadeModel = convertToEntity(especialidadeDTO);
        EspecialidadeModel savedEspecialidade = especialidadeRepository.save(especialidadeModel);
        return convertToDTO(savedEspecialidade);
    }

    public Optional<EspecialidadeDTO> updateEspecialidade(Long id, EspecialidadeDTO especialidadeDTO) {
        return especialidadeRepository.findById(id)
                .map(existingEspecialidade -> {
                    existingEspecialidade.setNome(especialidadeDTO.getNome());
                    EspecialidadeModel updatedEspecialidade = especialidadeRepository.save(existingEspecialidade);
                    return convertToDTO(updatedEspecialidade);
                });
    }

    public void deleteEspecialidade(Long id) {
        especialidadeRepository.deleteById(id);
    }

    private EspecialidadeDTO convertToDTO(EspecialidadeModel especialidadeModel) {
        EspecialidadeDTO especialidadeDTO = new EspecialidadeDTO();
        especialidadeDTO.setId(especialidadeModel.getId());
        especialidadeDTO.setNome(especialidadeModel.getNome());
        return especialidadeDTO;
    }

    private EspecialidadeModel convertToEntity(EspecialidadeDTO especialidadeDTO) {
        EspecialidadeModel especialidadeModel = new EspecialidadeModel();
        especialidadeModel.setId(especialidadeDTO.getId());
        especialidadeModel.setNome(especialidadeDTO.getNome());
        return especialidadeModel;
    }
}