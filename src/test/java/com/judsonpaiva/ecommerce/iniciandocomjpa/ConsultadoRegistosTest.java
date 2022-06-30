package com.judsonpaiva.ecommerce.iniciandocomjpa;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ConsultadoRegistosTest extends EntityManagerTest {

    @Test
    public void buscarPorIdentificador(){
        //Produto produto = entityManager.find(Produto.class, 1);
        Produto produto = entityManager.getReference(Produto.class, 1);
        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void actualizarReferencia(){
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Microfone Samson");

        entityManager.refresh(produto);

        Assert.assertEquals("Kindle", produto.getNome());
    }

}
