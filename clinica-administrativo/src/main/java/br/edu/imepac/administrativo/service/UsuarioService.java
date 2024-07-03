package br.edu.imepac.administrativo.service;

import br.edu.imepac.commons.dto.UsuarioDTO;
import br.edu.imepac.commons.model.UsuarioModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private List<UsuarioModel> usuarioRepository = new ArrayList<>();

    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO getUsuarioById(Long id) {
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        return optionalUsuario.map(this::convertToDTO).orElse(null);
    }

    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        UsuarioModel usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuarioModel);
        usuarioModel.setId(generateId()); // Replace with actual ID generation logic
        usuarioRepository.add(usuarioModel);
        return convertToDTO(usuarioModel);
    }

    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        if (optionalUsuario.isPresent()) {
            UsuarioModel existingUsuario = optionalUsuario.get();
            BeanUtils.copyProperties(usuarioDTO, existingUsuario);
            existingUsuario.setId(id); // Ensure ID remains unchanged
            return convertToDTO(existingUsuario);
        } else {
            return null;
        }
    }

    public boolean deleteUsuario(Long id) {
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        if (optionalUsuario.isPresent()) {
            usuarioRepository.removeIf(u -> u.getId().equals(id));
            return true;
        } else {
            return false;
        }
    }

    private UsuarioDTO convertToDTO(UsuarioModel usuarioModel) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        BeanUtils.copyProperties(usuarioModel, usuarioDTO);
        return usuarioDTO;
    }

    private Long generateId() {
        return System.currentTimeMillis();
    }
}