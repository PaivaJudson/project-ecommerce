package com.judsonpaiva.projectecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
@Table(name = "categoria")
public class Categoria {

    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;

    @Column(name = "categoria_pai_id")
    private Integer categoriaPaiID;

    @Id
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

    public Integer getCategoriaPaiID() {
        return categoriaPaiID;
    }

    public void setCategoriaPaiID(Integer categoriaPaiID) {
        this.categoriaPaiID = categoriaPaiID;
    }
}
