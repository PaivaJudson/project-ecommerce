package com.judsonpaiva.ecommerce.relacionamentos;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoPedidoToCliente(){
        Cliente cliente = entityManager.find(Cliente.class, 1);
        Pedido pedido = new Pedido(cliente, LocalDateTime.now(), null, null, StatusPedido.AGUARDANDO, BigDecimal.TEN, null);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();
    }

    @Test
    public void verificarRelacionamentoItemPedidoToPedidoe(){

        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido(cliente, LocalDateTime.now(), null, null, StatusPedido.AGUARDANDO, BigDecimal.TEN, null);

        ItemPedido itemPedido = new ItemPedido(pedido, produto, produto.getPreco(), 4);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();


    }



}
