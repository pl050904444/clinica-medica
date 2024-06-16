package br.edu.imepac.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;
}