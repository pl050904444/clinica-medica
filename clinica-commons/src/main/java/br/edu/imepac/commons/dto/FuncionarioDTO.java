package br.edu.imepac.commons.dto;

import lombok.Data;

@Data
public class FuncionarioDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String cargo;

    // Constructor with fields
    public FuncionarioDTO(Long id, String nome, String cpf, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
    }

    // Empty constructor (if needed)
    public FuncionarioDTO() {
    }
}