package com.judsonpaiva.ecommerce.entitymanager;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Categoria;
import org.junit.Test;

public class EstadoECicloDeVidaTes extends EntityManagerTest {

    @Test
    public void analisarEstados(){
        Categoria categoria = new Categoria();

        entityManager.persist(categoria);
        Categoria categoria1 = entityManager.find(Categoria.class, 1);

        entityManager.remove(categoria1);
        entityManager.persist(categoria1);
    }

}
