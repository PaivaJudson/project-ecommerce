package com.judsonpaiva.ecommerce.relacionamentos;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Categoria;
import org.junit.Assert;
import org.junit.Test;

public class AutoRelacionamentoTest extends EntityManagerTest {

    @Test
    public void relacionamentoCategoriaToCategoria(){

        Categoria categoriaPai = new Categoria();
        categoriaPai.setNome("Electrônicos");

        Categoria categoriaFilho = new Categoria();
        categoriaFilho.setNome("HP 2014");
        categoriaFilho.setCategoriaPaiID(categoriaPai);

        entityManager.getTransaction().begin();
        entityManager.persist(categoriaPai);
        entityManager.persist(categoriaFilho);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoria = entityManager.find(Categoria.class, categoriaFilho.getId());
        Assert.assertNotNull(categoria);
    }

}
