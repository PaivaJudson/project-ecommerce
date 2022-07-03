package com.judsonpaiva.projectecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private SexoCliente sexo;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    public Cliente(Integer id, String nome, SexoCliente sexo) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
    }

    public Cliente(String nome, SexoCliente sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public Cliente() {
    }

}
