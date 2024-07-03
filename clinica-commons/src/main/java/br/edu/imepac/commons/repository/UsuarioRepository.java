package br.edu.imepac.commons.repository;

import br.edu.imepac.commons.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    // You can define custom query methods here if needed
}