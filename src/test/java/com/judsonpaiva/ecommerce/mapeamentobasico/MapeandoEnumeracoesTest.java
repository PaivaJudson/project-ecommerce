package com.judsonpaiva.ecommerce.mapeamentobasico;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Cliente;
import com.judsonpaiva.projectecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class MapeandoEnumeracoesTest extends EntityManagerTest {

    @Test
    public void testarEnum(){
        Cliente cliente = new Cliente("Delvino José", SexoCliente.MASCULINO);
        cliente.setSexo(SexoCliente.MASCULINO);
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        //Cliente cl1 = entityManager.find(Cliente.class, );
        //Assert.assertNotNull(cl1);

    }
}
