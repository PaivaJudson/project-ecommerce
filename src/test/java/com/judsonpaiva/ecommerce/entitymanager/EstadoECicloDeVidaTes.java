package com.judsonpaiva.ecommerce.entitymanager;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.Categoria;
import com.judsonpaiva.projectecommerce.model.Pedido;
import com.judsonpaiva.projectecommerce.model.Produto;
import com.judsonpaiva.projectecommerce.model.StatusPedido;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLOutput;

public class EstadoECicloDeVidaTes extends EntityManagerTest {

    @Test
    public void analisarEstados(){
        Categoria categoria = new Categoria();

        entityManager.persist(categoria);
        Categoria categoria1 = entityManager.find(Categoria.class, 1);

        entityManager.remove(categoria1);
        entityManager.persist(categoria1);

        entityManager.detach(categoria1);
    }


    @Test
    public void verificarCache(){

        Produto produto = entityManager.find(Produto.class, 1);
        System.out.println(produto.getNome());

        System.out.println("-------------------------------------");
        entityManager.clear();

        Produto produtoResgatado = entityManager.find(Produto.class, produto.getId());
        System.out.println(produtoResgatado.getNome());


    }

    @Test
    public void gereciamentodeTransaction(){

        Pedido pedido = entityManager.find(Pedido.class, 1);

        entityManager.getTransaction().begin();
        pedido.setStatus(StatusPedido.PAGO);

        if (pedido.getPagamentoCartao() != null){
            entityManager.getTransaction().commit();
        }else{
            entityManager.getTransaction().rollback();
        }
    }

    @Test(expected = Exception.class)
    public void chamarFlush(){

        try {

            Pedido pedido = entityManager.find(Pedido.class, 1);
            pedido.setStatus(StatusPedido.PAGO);

            entityManager.flush();

            if (pedido.getPagamentoCartao() == null) {
                throw new RuntimeException("Pedido ainda não foi pago...");
            }
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    @Test
    public void usarContextoDePersistencia(){

        entityManager.getTransaction().begin();
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setPreco(new BigDecimal(100.0));

        Produto produto2 = new Produto();
        produto2.setNome("Caneca para café");

        entityManager.persist(produto2);

        Produto produto3 = new Produto();
        produto3.setNome("Caneca para chá");

        produto3 = entityManager.merge(produto3);

        entityManager.getTransaction().commit();
    }



}
