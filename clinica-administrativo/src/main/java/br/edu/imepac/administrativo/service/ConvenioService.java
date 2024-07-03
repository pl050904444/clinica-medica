package br.edu.imepac.administrativo.service;

import br.edu.imepac.commons.dto.ConvenioDTO;
import br.edu.imepac.commons.model.ConvenioModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConvenioService {

    // Assume a mock repository or service for demonstration
    // Replace with actual repository/service as per your application
    private List<ConvenioModel> convenioRepository = new ArrayList<>();

    @Autowired
    public ConvenioService() {
        // Initialize with some mock data for demonstration
    }

    public List<ConvenioDTO> getAllConvenios() {
        return convenioRepository.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ConvenioDTO getConvenioById(Long id) {
        Optional<ConvenioModel> optionalConvenio = convenioRepository.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        return optionalConvenio.map(this::convertToDTO).orElse(null);
    }

    public ConvenioDTO createConvenio(ConvenioDTO convenioDTO) {
        ConvenioModel convenioModel = new ConvenioModel();
        BeanUtils.copyProperties(convenioDTO, convenioModel);
        convenioModel.setId(generateId()); // Replace with actual ID generation logic
        convenioRepository.add(convenioModel);
        return convertToDTO(convenioModel);
    }

    public ConvenioDTO updateConvenio(Long id, ConvenioDTO convenioDTO) {
        Optional<ConvenioModel> optionalConvenio = convenioRepository.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (optionalConvenio.isPresent()) {
            ConvenioModel existingConvenio = optionalConvenio.get();
            BeanUtils.copyProperties(convenioDTO, existingConvenio);
            existingConvenio.setId(id); // Ensure ID remains unchanged
            return convertToDTO(existingConvenio);
        } else {
            return null;
        }
    }

    public boolean deleteConvenio(Long id) {
        Optional<ConvenioModel> optionalConvenio = convenioRepository.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (optionalConvenio.isPresent()) {
            convenioRepository.removeIf(c -> c.getId().equals(id));
            return true;
        } else {
            return false;
        }
    }

    // Helper method to convert ConvenioModel to ConvenioDTO
    private ConvenioDTO convertToDTO(ConvenioModel convenioModel) {
        ConvenioDTO convenioDTO = new ConvenioDTO();
        BeanUtils.copyProperties(convenioModel, convenioDTO);
        return convenioDTO;
    }

    // Replace with actual ID generation logic
    private Long generateId() {
        return System.currentTimeMillis(); // Example: Generate ID based on timestamp
    }
}