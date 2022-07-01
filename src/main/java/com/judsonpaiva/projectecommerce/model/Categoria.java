package com.judsonpaiva.projectecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class Categoria {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private String nome;
    private Integer categoriaPaiID;

}
