package com.fuctura.bibliotecaSab.repositories;

import com.fuctura.bibliotecaSab.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {


}
