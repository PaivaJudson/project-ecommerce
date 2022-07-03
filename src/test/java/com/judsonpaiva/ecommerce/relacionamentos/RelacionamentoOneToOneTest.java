package com.judsonpaiva.ecommerce.relacionamentos;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RelacionamentoOneToOneTest extends EntityManagerTest {

    @Test
    public void relacionarManyToManyPedidoToPagamentoCartao(){

        Pedido pedido = entityManager.find(Pedido.class, 1);

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setNumero("1234");
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
        pagamentoCartao.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedido1 = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedido1.getPagamentoCartao());
    }

    @Test
    public void relacionarManyToManyPedidoToNotaFiscal() {

        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setXml("ABCD.xml");
        notaFiscal.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();

        entityManager.clear();
    }

}
