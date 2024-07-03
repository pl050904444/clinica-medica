package br.edu.imepac.agendamento.repository;

import br.edu.imepac.agendamento.model.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<ConsultaModel, Long> {
}