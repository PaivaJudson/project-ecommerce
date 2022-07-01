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
public class Estoque {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer produtoId;
    private Integer quantidade;

}
