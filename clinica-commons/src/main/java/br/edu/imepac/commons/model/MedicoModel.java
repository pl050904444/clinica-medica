package br.edu.imepac.commons.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MedicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String crm;

    @ManyToOne
    @JoinColumn(name = "especialidade_id")
    private EspecialidadeModel especialidade;
}