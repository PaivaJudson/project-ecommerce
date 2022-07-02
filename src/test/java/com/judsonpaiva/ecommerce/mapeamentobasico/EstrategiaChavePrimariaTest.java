package com.judsonpaiva.ecommerce.mapeamentobasico;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Categoria;
import org.junit.Assert;
import org.junit.Test;

public class EstrategiaChavePrimariaTest extends EntityManagerTest {

    @Test
    public void testarEstrategiaAuto(){

        Categoria categoria = new Categoria("Electrônico", null);
       // categoria.setNome("Eletrônicos");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaResult = entityManager.find(Categoria.class, categoria.getId());
        Assert.assertNotNull(categoriaResult);

    }

}
