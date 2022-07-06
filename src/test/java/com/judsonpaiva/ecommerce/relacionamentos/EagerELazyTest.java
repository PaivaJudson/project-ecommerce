package com.judsonpaiva.ecommerce.relacionamentos;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Pedido;
import org.junit.Test;

public class EagerELazyTest extends EntityManagerTest {

    @Test
    public void comportamentoPedido(){
        Pedido pedido = entityManager.find(Pedido.class, 1);

        pedido.getItens().isEmpty();
    }
}
