package com.judsonpaiva.ecommerce.iniciandocomjpa;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Produto;

public class OperacoesComTransactionsTest extends EntityManagerTest {

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
