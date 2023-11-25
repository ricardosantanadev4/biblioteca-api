package com.fuctura.bibliotecaSab.controllers;

import com.fuctura.bibliotecaSab.model.Categoria;
import com.fuctura.bibliotecaSab.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/{id}")
    public Categoria findById(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        return cat;
    }

    @GetMapping
    public List<Categoria> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return list;
    }

    @PostMapping
    public Categoria save(@RequestBody Categoria obj) {
        return categoriaService.save(obj);
    }

}
