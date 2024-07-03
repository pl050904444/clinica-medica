package br.edu.imepac.commons.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String senha;

    // Constructor with fields
    public UsuarioDTO(Long id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    // Empty constructor (if needed)
    public UsuarioDTO() {
    }

    // Getters and setters as generated by Lombok
}