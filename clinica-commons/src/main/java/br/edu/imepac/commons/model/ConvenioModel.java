package br.edu.imepac.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class ConvenioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
}