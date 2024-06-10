package br.edu.imepac.repository;

import br.edu.imepac.model.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepositorio extends JpaRepository<ConsultaModel, Long> {
}