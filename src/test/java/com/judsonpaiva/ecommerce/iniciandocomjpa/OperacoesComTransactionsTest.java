package com.judsonpaiva.ecommerce.iniciandocomjpa;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransactionsTest extends EntityManagerTest {

    @Test
    public void impedirOperacoesComBancoDeDados(){

        //Produto produto = new Produto(1, "Kidle Paper", "Conheça o novo Kindle", new BigDecimal(599));
        Produto produtoM = entityManager.find(Produto.class, 1);
        entityManager.detach(produtoM);
        produtoM.setNome("Kindle Paper Today");
        produtoM.setPreco(new BigDecimal(599));


        entityManager.getTransaction().begin();
        entityManager.merge(produtoM);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produto = entityManager.find(Produto.class, 1);
        Assert.assertEquals("Kindle Paper Today", produto.getNome());
    }


    @Test
    public void mostrarDiferencaPersistEMerge(){

        Produto produtoPersist = new Produto(5, "Smartphone One Plus", "O Processador mais rápido", new BigDecimal(2000));

        entityManager.getTransaction().begin();
        entityManager.persist(produtoPersist);
        produtoPersist.setNome("Smartphone Two Plus");
        entityManager.getTransaction().commit();

        entityManager.clear();


        Produto produtoMerge = new Produto(6, "Smartphone Samsung US", "O Processador mais rápido", new BigDecimal(2000));

        entityManager.getTransaction().begin();
        produtoMerge = entityManager.merge(produtoMerge);
        produtoMerge.setNome("Notebook Dell 2022");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoV = entityManager.find(Produto.class, 6);
        Assert.assertNotNull(produtoV);
    }

    @Test
    public void insercaoComMerge(){

        Produto produto = new Produto(4, "Microfone Rode Videmic", "A melhor qualidade de som", new BigDecimal(5000));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoV = entityManager.find(Produto.class, 4);
        Assert.assertNotNull(produtoV);
    }

    @Test
    public void actualizarObjecto(){

        //Produto produto = new Produto(1, "Kidle Paper", "Conheça o novo Kindle", new BigDecimal(599));
        Produto produtoM = entityManager.find(Produto.class, 1);
        produtoM.setNome("Kindle Paper Today");
        produtoM.setPreco(new BigDecimal(599));

        entityManager.getTransaction().begin();
        entityManager.merge(produtoM);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produto = entityManager.find(Produto.class, 1);
        Assert.assertEquals("Kindle Paper Today", produto.getNome());
    }

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
