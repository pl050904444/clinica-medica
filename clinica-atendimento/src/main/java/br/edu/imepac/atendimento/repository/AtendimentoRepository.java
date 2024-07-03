package br.edu.imepac.atendimento.repository;

import br.edu.imepac.atendimento.model.AtendimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<AtendimentoModel, Long> {
}