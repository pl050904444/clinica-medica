package br.edu.imepac.services;

import br.edu.imepac.models.ConvenioModel;
import br.edu.imepac.repositories.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConvenioService {

    @Autowired
    private ConvenioRepository convenioRepository;

    public ConvenioModel save(ConvenioModel convenio) {
        return convenioRepository.save(convenio);
    }

    public List<ConvenioModel> getAllConvenios() {
        return convenioRepository.findAll();
    }

    public Optional<ConvenioModel> getConvenioById(Long id) {
        return convenioRepository.findById(id);
    }

    public ConvenioModel updateConvenio(Long id, ConvenioModel updatedConvenio) {
        Optional<ConvenioModel> existingConvenioOptional = convenioRepository.findById(id);
        if (existingConvenioOptional.isPresent()) {
            ConvenioModel existingConvenio = existingConvenioOptional.get();
            existingConvenio.setName(updatedConvenio.getName());
            // You can also update other fields here
            return convenioRepository.save(existingConvenio);
        } else {
            // Handle the case when the convenio with the given ID is not found
            return null;
        }
    }

    public void deleteConvenio(Long id) {
        convenioRepository.deleteById(id);
    }
}