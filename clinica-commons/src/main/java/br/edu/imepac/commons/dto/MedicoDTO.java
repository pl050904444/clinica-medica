package br.edu.imepac.commons.dto;

import br.edu.imepac.commons.model.MedicoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {
    private Long id;
    private String nome;
    private String crm;
    private Long especialidadeId;

    // Static method to convert from MedicoModel entity to MedicoDTO
    public static MedicoDTO fromEntity(MedicoModel medico) {
        MedicoDTO dto = new MedicoDTO();
        dto.setId(medico.getId());
        dto.setNome(medico.getNome());
        dto.setCrm(medico.getCrm());
        if (medico.getEspecialidade() != null) {
            dto.setEspecialidadeId(medico.getEspecialidade().getId());
        }
        return dto;
    }
}