package com.judsonpaiva.projectecommerce.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
@Table(name = "categoria")
public class Categoria {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_pai_id")
    private Categoria categoriaPaiID;

    @OneToMany(mappedBy = "categoriaPaiID")
    private List<Categoria> categorias;

    public Categoria(String nome, Categoria categoriaPaiID) {
        this.nome = nome;
        this.categoriaPaiID = categoriaPaiID;
    }

    public Categoria() {
    }
}
