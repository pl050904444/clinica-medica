package br.edu.imepac.agendamento.model;

import br.edu.imepac.commons.model.MedicoModel;
import br.edu.imepac.commons.model.PacienteModel;
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