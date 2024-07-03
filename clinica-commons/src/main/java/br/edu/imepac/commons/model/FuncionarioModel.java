package br.edu.imepac.commons.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String cargo;
}