package br.edu.imepac.commons.repository;

import br.edu.imepac.commons.model.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel, Long> {
    // You can define custom query methods here if needed
}