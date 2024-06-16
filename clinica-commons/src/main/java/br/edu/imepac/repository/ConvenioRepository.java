package br.edu.imepac.repository;

import br.edu.imepac.model.ConvenioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvenioRepository extends JpaRepository<ConvenioModel, Long> {
}