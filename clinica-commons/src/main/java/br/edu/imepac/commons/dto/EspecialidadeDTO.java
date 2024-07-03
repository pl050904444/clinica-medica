package br.edu.imepac.commons.dto;

import lombok.Data;

@Data
public class EspecialidadeDTO {
    private Long id;
    private String nome;

    // Constructor with fields
    public EspecialidadeDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Empty constructor (if needed)
    public EspecialidadeDTO() {
    }
}