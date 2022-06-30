package com.judsonpaiva.ecommerce.iniciandocomjpa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultadoRegistosTest {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeClass
    public static void setUpBeforeClass(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Project-Ecommerce");
    }

    @AfterClass
    public static void tearDownAfterClass(){
        entityManagerFactory.close();
    }

    @Before
    public void setUp(){
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown(){
        entityManager.close();
    }
}
