package br.edu.imepac.commons.repository;

import br.edu.imepac.commons.model.EspecialidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository extends JpaRepository<EspecialidadeModel, Long> {
    // You can define additional query methods here if needed
}