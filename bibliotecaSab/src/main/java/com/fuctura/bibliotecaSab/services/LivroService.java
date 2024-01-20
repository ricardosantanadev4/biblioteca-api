package com.fuctura.bibliotecaSab.services;
import com.fuctura.bibliotecaSab.dtos.LivroDTO;
import com.fuctura.bibliotecaSab.exceptions.ObjectNotFoundException;
import com.fuctura.bibliotecaSab.models.Categoria;
import com.fuctura.bibliotecaSab.models.Livro;
import com.fuctura.bibliotecaSab.repositories.CategoriaRepository;
import com.fuctura.bibliotecaSab.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Livro> findAllLivroByCategoriaName(String nome) {
        categoriaService.buscarPorNome(nome);
        return livroRepository.findByCategoriaNomeContainingIgnoreCase(nome);
    }

    public Livro save(Integer id_cat, LivroDTO livroDTO) {
        livroDTO.setId(null);
        Categoria cat = categoriaService.findById(id_cat);
        livroDTO.setCategoria(cat);
        return livroRepository.save(new Livro(livroDTO));
    }

    public Livro upDate(Integer id, LivroDTO livroDTO) {
        Livro livro = findById(id);
        livroDTO.setId(id);
        upDateDados(livro, livroDTO);
        return livroRepository.save(livro);
    }

    public void delete(Integer id) {
        findById(id);
        livroRepository.deleteById(id);
    }

    private void upDateDados(Livro livro, LivroDTO livroDTO) {
        livro.setTitulo(livroDTO.getTitulo());
        livro.setNome_autor(livroDTO.getNome_autor());
        livro.setTexto(livroDTO.getTexto());
        livro.setTamanho(livroDTO.getTamanho());
        livro.setCategoria(livroDTO.getCategoria());
    }
}
