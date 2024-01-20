package com.fuctura.bibliotecaSab.repositories;

import com.fuctura.bibliotecaSab.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNome(String nome);

    Optional<Categoria> findByNomeContainingIgnoreCase(String nome);
}
