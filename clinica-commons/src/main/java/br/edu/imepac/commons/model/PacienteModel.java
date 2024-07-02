package br.edu.imepac.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class PacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String endereco;

    @ManyToOne
    @JoinColumn(name = "convenio_id")
    private ConvenioModel convenio;
}