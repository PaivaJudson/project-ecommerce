package com.judsonpaiva.projectecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class ItemPedido {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer pedidoId;
    private Integer produtoId;
    private BigDecimal precoProduto;
    private Integer quantidade;

}
