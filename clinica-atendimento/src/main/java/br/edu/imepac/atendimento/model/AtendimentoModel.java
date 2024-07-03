package br.edu.imepac.atendimento.model;

import br.edu.imepac.commons.model.ConvenioModel;
import br.edu.imepac.commons.model.MedicoModel;
import br.edu.imepac.commons.model.PacienteModel;
import br.edu.imepac.commons.model.ProntuarioModel;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class AtendimentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private MedicoModel medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name = "convenio_id")
    private ConvenioModel convenio;

    // Constructors, getters, and setters (generated by Lombok)
}