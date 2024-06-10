package br.edu.imepac.dtos;

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