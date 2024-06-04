package br.edu.imepac.services;

import br.edu.imepac.models.MedicoModel;
import br.edu.imepac.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    // Method to save a doctor
    public MedicoModel save(MedicoModel medico) {
        medicoRepository.save(medico);
        return medico;
    }

    // Method to retrieve all doctors
    public List<MedicoModel> getAllDoctors() {
        return medicoRepository.findAll();
    }

    // Method to retrieve a doctor by ID
    public Optional<MedicoModel> getDoctorById(Long id) {
        return medicoRepository.findById(id);
    }

    // Method to update a doctor
    // Method to update a doctor
    public MedicoModel updateDoctor(Long id, MedicoModel updatedMedico) {
        Optional<MedicoModel> existingMedicoOptional = medicoRepository.findById(id);
        if (existingMedicoOptional.isPresent()) {
            MedicoModel existingMedico = existingMedicoOptional.get();
            existingMedico.setNome(updatedMedico.getNome());
            existingMedico.setCrm(updatedMedico.getCrm());
            // You can also update other fields here
            return medicoRepository.save(existingMedico);
        } else {
            // Handle the case when the doctor with the given ID is not found
            return null;
        }
    }

    // Method to delete a doctor by ID
    public void deleteDoctor(Long id) {
        medicoRepository.deleteById(id);
    }
}