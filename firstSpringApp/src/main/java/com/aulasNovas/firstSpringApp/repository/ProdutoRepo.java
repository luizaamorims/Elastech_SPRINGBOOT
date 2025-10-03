package com.aulasNovas.firstSpringApp.repository;


import com.aulasNovas.firstSpringApp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepo extends JpaRepository<Produto, Integer> {
}

