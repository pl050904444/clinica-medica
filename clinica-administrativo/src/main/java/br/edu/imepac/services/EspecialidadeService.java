package br.edu.imepac.services;

import br.edu.imepac.models.EspecialidadeModel;
import br.edu.imepac.repositories.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public EspecialidadeModel save(EspecialidadeModel especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public List<EspecialidadeModel> getAllEspecialidades() {
        return especialidadeRepository.findAll();
    }

    public Optional<EspecialidadeModel> getEspecialidadeById(Long id) {
        return especialidadeRepository.findById(id);
    }

    public EspecialidadeModel updateEspecialidade(Long id, EspecialidadeModel updatedEspecialidade) {
        Optional<EspecialidadeModel> existingEspecialidadeOptional = especialidadeRepository.findById(id);
        if (existingEspecialidadeOptional.isPresent()) {
            EspecialidadeModel existingEspecialidade = existingEspecialidadeOptional.get();
            existingEspecialidade.setName(updatedEspecialidade.getName());
            // You can also update other fields here
            return especialidadeRepository.save(existingEspecialidade);
        } else {
            // Handle the case when the especialidade with the given ID is not found
            return null;
        }
    }

    public void deleteEspecialidade(Long id) {
        especialidadeRepository.deleteById(id);
    }
}