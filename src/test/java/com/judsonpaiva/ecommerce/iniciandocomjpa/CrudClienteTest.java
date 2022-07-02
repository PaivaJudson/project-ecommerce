package com.judsonpaiva.ecommerce.iniciandocomjpa;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Cliente;
import com.judsonpaiva.projectecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class CrudClienteTest extends EntityManagerTest {

    @Test
    public void inserirRegisto(){

        Cliente cliente = new Cliente("Jéssica Paiva", SexoCliente.FEMENINO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        //Cliente cliente1 = entityManager.find(Cliente.class, 3);
        //Assert.assertNotNull(cliente1);

    }

    @Test
    public void procurarPorID(){

        Cliente cliente1 = entityManager.find(Cliente.class, 1);
        Assert.assertEquals("Judson Paiva", cliente1.getNome());
    }

    @Test
    public void actualizarCliente(){

        Cliente cliente = entityManager.find(Cliente.class, 2);
        cliente.setNome("Leonor Paiva");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Cliente cliente1 = entityManager.find(Cliente.class, 2);
        Assert.assertEquals("Leonor Paiva", cliente1.getNome());
    }

    @Test
    public void removerCliente(){
        Cliente cliente = entityManager.find(Cliente.class, 1);
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
    }

}
