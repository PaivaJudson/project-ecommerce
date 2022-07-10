package com.judsonpaiva.projectecommerce.model;


import com.judsonpaiva.projectecommerce.model.Estoque;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    @ManyToMany
    @JoinTable(name = "produto_categoria",
               joinColumns = @JoinColumn(name = "produto_id"),
               inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias;

    @OneToOne(mappedBy = "produtoId")
    private Estoque estoque;

    public Produto(Integer id, String nome, String descricao, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto() {}


}
