package br.com.aulas.escolaapp.repository;

import br.com.aulas.escolaapp.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepo extends JpaRepository<Aluno, Integer> {
}
