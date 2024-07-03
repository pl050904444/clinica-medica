package br.edu.imepac.agendamento.dto;

import java.time.LocalDateTime;

import br.edu.imepac.commons.dto.MedicoDTO;
import br.edu.imepac.commons.dto.PacienteDTO;
import lombok.Data;

@Data
public class ConsultaDTO {
    private Long id;
    private MedicoDTO medico;
    private PacienteDTO paciente;
    private LocalDateTime data;
    private String localizacao;
    private String metodoPagamento;
}