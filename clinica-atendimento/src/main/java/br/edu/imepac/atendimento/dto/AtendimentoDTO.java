package br.edu.imepac.atendimento.dto;

import br.edu.imepac.commons.model.ConvenioModel;
import br.edu.imepac.commons.model.MedicoModel;
import br.edu.imepac.commons.model.PacienteModel;
import lombok.Data;

@Data
public class AtendimentoDTO {
    private Long id;
    private MedicoModel medico;
    private PacienteModel paciente;
    private ConvenioModel convenio;
}