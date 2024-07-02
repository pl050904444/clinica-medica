package br.edu.imepac.commons.dto;

import java.time.LocalDateTime;
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