package com.fuctura.bibliotecaSab.services;

import com.fuctura.bibliotecaSab.exceptions.ObjectNotFoundException;
import com.fuctura.bibliotecaSab.model.Livro;
import com.fuctura.bibliotecaSab.repositories.CategoriaRepository;
import com.fuctura.bibliotecaSab.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()) {
            return livro.get();
        }
        throw new ObjectNotFoundException("Livro não encontrado!");
    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findById(id_cat);
        return livroRepository.findAllByCategoria(id_cat);
    }
}
