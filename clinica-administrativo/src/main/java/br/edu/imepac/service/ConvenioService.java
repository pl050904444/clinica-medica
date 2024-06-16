package br.edu.imepac.service;

import br.edu.imepac.dtos.ConvenioDTO;

import br.edu.imepac.repository.ConvenioRepository;
import br.edu.imepac.model.ConvenioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConvenioService {

    @Autowired
    private ConvenioRepository convenioRepository;

    public List<ConvenioDTO> getAllConvenios() {
        return convenioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ConvenioDTO> getConvenioById(Long id) {
        return convenioRepository.findById(id)
                .map(this::convertToDTO);
    }

    public ConvenioDTO createConvenio(ConvenioDTO convenioDTO) {
        ConvenioModel convenioModel = convertToEntity(convenioDTO);
        ConvenioModel savedConvenio = convenioRepository.save(convenioModel);
        return convertToDTO(savedConvenio);
    }

    public Optional<ConvenioDTO> updateConvenio(Long id, ConvenioDTO convenioDTO) {
        return convenioRepository.findById(id)
                .map(existingConvenio -> {
                    existingConvenio.setNome(convenioDTO.getNome());
                    ConvenioModel updatedConvenio = convenioRepository.save(existingConvenio);
                    return convertToDTO(updatedConvenio);
                });
    }

    public void deleteConvenio(Long id) {
        convenioRepository.deleteById(id);
    }

    private ConvenioDTO convertToDTO(ConvenioModel convenioModel) {
        ConvenioDTO convenioDTO = new ConvenioDTO();
        convenioDTO.setId(convenioModel.getId());
        convenioDTO.setNome(convenioModel.getNome());
        return convenioDTO;
    }

    private ConvenioModel convertToEntity(ConvenioDTO convenioDTO) {
        ConvenioModel convenioModel = new ConvenioModel();
        convenioModel.setId(convenioDTO.getId());
        convenioModel.setNome(convenioDTO.getNome());
        return convenioModel;
    }
}