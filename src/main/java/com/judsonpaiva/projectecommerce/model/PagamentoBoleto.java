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
public class PagamentoBoleto {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer pedidoId;
    private StatusPagamento status;
    private String codigoBarras;

}
