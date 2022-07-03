package com.judsonpaiva.projectecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   // @Column(name = "pedido_id")
    //private Integer pedidoId;
    @ManyToOne
    private Pedido pedido;

    @Column(name = "produto_id")
    private Integer produtoId;

    @Column(name = "preco_produto")
    private BigDecimal precoProduto;
    private Integer quantidade;

    public ItemPedido(Pedido pedido, Integer produtoId, BigDecimal precoProduto, Integer quantidade) {
        this.pedido = pedido;
        this.produtoId = produtoId;
        this.precoProduto = precoProduto;
        this.quantidade = quantidade;
    }

    public ItemPedido() {
    }
}
