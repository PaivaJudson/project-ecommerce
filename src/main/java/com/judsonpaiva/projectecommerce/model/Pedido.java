package com.judsonpaiva.projectecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private LocalDateTime dataPedido;
    private LocalDateTime dataConclusao;
    private Integer notaFiscalId;
    private StatusPedido status;
    private Integer total;

}
