package br.edu.imepac.commons.repository;

import br.edu.imepac.commons.model.ProntuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuarioRepository extends JpaRepository<ProntuarioModel, Long> {
    // You can define custom query methods here if needed
}