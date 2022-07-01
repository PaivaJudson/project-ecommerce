package com.judsonpaiva.projectecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class PagamentoCartao {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer pedidoId;
    private StatusPagamento status;
    private String numero;

}
