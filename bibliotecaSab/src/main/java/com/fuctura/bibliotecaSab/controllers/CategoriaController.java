package com.fuctura.bibliotecaSab.controllers;

import com.fuctura.bibliotecaSab.dtos.CategoriaDTO;
import com.fuctura.bibliotecaSab.model.Categoria;
import com.fuctura.bibliotecaSab.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    //@GetMapping("/{id}") = buscar por id
    //@GetMapping() = buscar todos
    //@PostMapping(obj) = inserir no banco
    //@PutMapping(obj) = atualizar no banco
    //@DeleteMapping(id) = deletar obj

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj -> modelMapper.map(obj, CategoriaDTO.class)).
                collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria cat = categoriaService.save(categoriaDTO);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDTO.class));

    }

}
