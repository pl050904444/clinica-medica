package br.edu.imepac.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class ProntuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
}