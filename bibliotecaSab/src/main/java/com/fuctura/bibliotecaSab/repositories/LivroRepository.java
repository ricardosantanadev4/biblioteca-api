package com.fuctura.bibliotecaSab.repositories;

import com.fuctura.bibliotecaSab.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query(value = "SELECT obj FROM Livro obj WHERE obj.categoria.id =:id_cat")
    List<Livro> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);



}
