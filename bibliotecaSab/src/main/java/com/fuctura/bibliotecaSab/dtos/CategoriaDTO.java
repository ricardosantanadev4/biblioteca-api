package com.fuctura.bibliotecaSab.dtos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class CategoriaDTO {

    private Integer id;

    @NotEmpty(message = "O campo NOME é requerido")
    @Length(min = 5, max = 50, message = "O campo NOME deve conter entre 5 e 50 caracteres")
    private String nome;

    @NotEmpty(message = "O campo DESCRIÇÃO é requerido")
    @Length(min = 50, max = 200, message = "O campo DESCRIÇÃO deve conter entre 50 e 200 caracteres")
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
