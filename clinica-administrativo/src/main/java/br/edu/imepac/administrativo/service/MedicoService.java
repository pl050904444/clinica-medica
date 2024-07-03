package br.edu.imepac.administrativo.service;

import br.edu.imepac.commons.dto.MedicoDTO;
import br.edu.imepac.commons.model.EspecialidadeModel;
import br.edu.imepac.commons.model.MedicoModel;
import br.edu.imepac.commons.repository.EspecialidadeRepository;
import br.edu.imepac.commons.repository.MedicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public List<MedicoDTO> getAllMedicos() {
        return medicoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MedicoDTO getMedicoById(Long id) {
        Optional<MedicoModel> optionalMedico = medicoRepository.findById(id);
        return optionalMedico.map(this::convertToDTO).orElse(null);
    }

    public MedicoDTO createMedico(MedicoDTO medicoDTO) {
        MedicoModel medicoModel = new MedicoModel();
        BeanUtils.copyProperties(medicoDTO, medicoModel);
        Optional<EspecialidadeModel> especialidade = especialidadeRepository.findById(medicoDTO.getEspecialidadeId());
        especialidade.ifPresent(medicoModel::setEspecialidade);
        MedicoModel savedMedico = medicoRepository.save(medicoModel);
        return convertToDTO(savedMedico);
    }

    public MedicoDTO updateMedico(Long id, MedicoDTO medicoDTO) {
        Optional<MedicoModel> optionalMedico = medicoRepository.findById(id);
        if (optionalMedico.isPresent()) {
            MedicoModel existingMedico = optionalMedico.get();
            BeanUtils.copyProperties(medicoDTO, existingMedico, "id");
            Optional<EspecialidadeModel> especialidade = especialidadeRepository.findById(medicoDTO.getEspecialidadeId());
            especialidade.ifPresent(existingMedico::setEspecialidade);
            MedicoModel updatedMedico = medicoRepository.save(existingMedico);
            return convertToDTO(updatedMedico);
        } else {
            return null;
        }
    }

    public boolean deleteMedico(Long id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private MedicoDTO convertToDTO(MedicoModel medicoModel) {
        MedicoDTO medicoDTO = new MedicoDTO();
        BeanUtils.copyProperties(medicoModel, medicoDTO);
        medicoDTO.setEspecialidadeId(medicoModel.getEspecialidade().getId());
        return medicoDTO;
    }
}