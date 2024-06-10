package br.edu.imepac.model;

import javax.persistence.*;
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
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;
    private String localizacao;
    private String metodoPagamento;
}