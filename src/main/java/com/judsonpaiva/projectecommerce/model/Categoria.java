package com.judsonpaiva.projectecommerce.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
@Table(name = "categoria")
public class Categoria {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    @Column(name = "categoria_pai_id")
    private Integer categoriaPaiID;

    public Categoria(String nome, Integer categoriaPaiID) {
        this.nome = nome;
        this.categoriaPaiID = categoriaPaiID;
    }

    public Categoria() {
    }
}
