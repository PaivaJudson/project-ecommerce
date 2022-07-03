package com.judsonpaiva.ecommerce.relacionamentos;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Categoria;
import com.judsonpaiva.projectecommerce.model.Produto;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RelacionamentoManyToMayTest extends EntityManagerTest {

    @Test
    public void relacionarManyToManyProdutosToCategorias(){

        Produto produto = entityManager.find(Produto.class, 1);
        Categoria categoria = entityManager.find(Categoria.class, 1);

        entityManager.getTransaction().begin();
        produto.setCategorias(Arrays.asList(categoria));
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
    }

}
