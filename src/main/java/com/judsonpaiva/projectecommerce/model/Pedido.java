package com.judsonpaiva.projectecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
@Table(name = "pedido")
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Column(name = "cliente_id")
    //private Integer clienteID;
    @ManyToOne(optional = false)
    @JoinColumn(name ="cliente_id")
    private Cliente cliente;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @Column(name = "nota_fiscal_id")
    private Integer notaFiscalId;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private BigDecimal total;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    private List<ItemPedido> itens;

    @Embedded
    private EnderecoEntregaPedido enderecoEntrega;

    @OneToOne(mappedBy = "pedido")
    private PagamentoCartao pagamentoCartao;

    public Pedido(Cliente cliente, LocalDateTime dataPedido, LocalDateTime dataConclusao, Integer notaFiscalId, StatusPedido status, BigDecimal total, EnderecoEntregaPedido enderecoEntrega) {
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.dataConclusao = dataConclusao;
        this.notaFiscalId = notaFiscalId;
        this.status = status;
        this.total = total;
        this.enderecoEntrega = enderecoEntrega;
    }

    public Pedido() {
    }
}
