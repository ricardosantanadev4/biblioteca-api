package com.fuctura.bibliotecaSab.controllers;

import com.fuctura.bibliotecaSab.dtos.LivroDTO;
import com.fuctura.bibliotecaSab.models.Livro;
import com.fuctura.bibliotecaSab.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable Integer id) {
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(new LivroDTO(livro));
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id) {
        List<Livro> list = livroService.findAll(id);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));
        //localhost:8080/livro?categoria=1
    }

    @GetMapping("categoria/{nome}")
    public ResponseEntity<List<LivroDTO>> findAllByNome(@PathVariable String nome) {
        List<Livro> list = livroService.findAllLivroByCategoriaName(nome);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<LivroDTO> save(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
                                         @Valid @RequestBody LivroDTO livroDTO) {
        Livro livro = livroService.save(id_cat, livroDTO);
        return ResponseEntity.ok().body(new LivroDTO(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> upDate(@PathVariable Integer id, @RequestBody LivroDTO livroDTO) {
        Livro livro = livroService.upDate(id, livroDTO);
        return ResponseEntity.ok().body(new LivroDTO(livro));
    }

}
