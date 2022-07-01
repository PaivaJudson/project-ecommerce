package com.judsonpaiva.projectecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class NotaFiscal {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer pedido;
    private String xml;
    private Date dataEmissao;
}
