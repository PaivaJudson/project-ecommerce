package com.judsonpaiva.ecommerce.iniciandocomjpa;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransactionsTest extends EntityManagerTest {

    @Test
    public void removerObjecto(){

        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        Produto produtoV = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoV);

    }


    @Test
    public void inserirOPrimeiroObjecto(){

        Produto produto = new Produto(2, "Câmera Canon", "A melhor definição para suas fotos", new BigDecimal(5000));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoV = entityManager.find(Produto.class, 1);
        Assert.assertNotNull(produtoV);

    }


    public void abrirEFecharTransaction(){

        Produto produto = new Produto(); // somente para não mostrar erros

        entityManager.getTransaction().begin();
        /*
        entityManager.persist(produto);
        entityManager.merge(produto);
        entityManager.remove(produto);
        */
        entityManager.getTransaction().commit();
    }

}
