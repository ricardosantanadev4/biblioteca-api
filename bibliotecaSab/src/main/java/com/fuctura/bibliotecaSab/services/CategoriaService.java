package com.fuctura.bibliotecaSab.services;

import com.fuctura.bibliotecaSab.dtos.CategoriaDTO;
import com.fuctura.bibliotecaSab.exceptions.DataIntegrityViolationException;
import com.fuctura.bibliotecaSab.exceptions.IllegalArgumentException;
import com.fuctura.bibliotecaSab.exceptions.ObjectNotFoundException;
import com.fuctura.bibliotecaSab.model.Categoria;
import com.fuctura.bibliotecaSab.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Categoria findById(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        //return cat.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));
        if (cat.isPresent()) {
            return cat.get();
        }
        throw new ObjectNotFoundException("Categoria não encontrada!");
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(CategoriaDTO objDTO) {
        findByNome(objDTO);
        objDTO.setId(null);
        return categoriaRepository.save(modelMapper.map(objDTO, Categoria.class));
    }

    public Categoria upDate(CategoriaDTO categoriaDTO) {
        findById(categoriaDTO.getId());
        return categoriaRepository.save(modelMapper.map(categoriaDTO, Categoria.class));
    }

    public void delete(Integer id) {
        findById(id);
        Optional<Categoria> cat = categoriaRepository.findById(id);
        if (cat.get().getLivros().size() > 0) {
            throw new DataIntegrityViolationException("Categoria possui livros, não pode ser deletada!");
        }
        categoriaRepository.deleteById(id);
    }

    private void findByNome(CategoriaDTO categoriaDTO) {
        Optional<Categoria> cat = categoriaRepository.findByNome(categoriaDTO.getNome());
        if (cat.isPresent() && cat.get().getNome().equals(categoriaDTO.getNome())) {
            throw new IllegalArgumentException("Já existe uma categoria com este nome " + categoriaDTO.getNome());
        }
    }
}
