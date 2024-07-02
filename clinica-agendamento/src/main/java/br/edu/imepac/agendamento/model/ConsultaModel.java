package br.edu.imepac.commons.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class ConsultaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private MedicoModel medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel paciente;

    private LocalDateTime data;
    private String localizacao;
    private String metodoPagamento;
}