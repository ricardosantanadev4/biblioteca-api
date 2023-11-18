package com.fuctura.bibliotecaSab.repositories;

import com.fuctura.bibliotecaSab.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {


}
