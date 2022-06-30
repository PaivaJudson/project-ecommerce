package com.judsonpaiva.projectecommerce.util;

import com.judsonpaiva.projectecommerce.model.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IniciarUnidadeDePersistence {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Project-Ecommerce");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Produto p1 = entityManager.find(Produto.class, 1);
        System.out.println(p1.getNome());



        entityManager.close();
        entityManagerFactory.close();
    }
}
