package com.judsonpaiva.projectecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.security.PrivilegedAction;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente {
    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private String nome;
    private SexoCliente sexo;

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente() {
    }

}
