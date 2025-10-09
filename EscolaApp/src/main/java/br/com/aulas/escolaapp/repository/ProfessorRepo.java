package br.com.aulas.escolaapp.repository;

import br.com.aulas.escolaapp.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepo extends JpaRepository<Professor, Integer> {
}
