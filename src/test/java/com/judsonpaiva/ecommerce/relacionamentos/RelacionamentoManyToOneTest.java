package com.judsonpaiva.ecommerce.relacionamentos;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Cliente;
import com.judsonpaiva.projectecommerce.model.EnderecoEntregaPedido;
import com.judsonpaiva.projectecommerce.model.Pedido;
import com.judsonpaiva.projectecommerce.model.StatusPedido;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){

        Cliente cliente = entityManager.find(Cliente.class, 1);
        Pedido pedido = new Pedido(cliente, LocalDateTime.now(), null, null, StatusPedido.AGUARDANDO, BigDecimal.TEN, null);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

    }

}
