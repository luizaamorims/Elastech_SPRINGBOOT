package br.com.aulas.escolaapp.repository;

import br.com.aulas.escolaapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);
}
