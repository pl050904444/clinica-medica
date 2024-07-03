package br.edu.imepac.commons.repository;

import br.edu.imepac.commons.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {
    // You can define custom query methods here if needed
}