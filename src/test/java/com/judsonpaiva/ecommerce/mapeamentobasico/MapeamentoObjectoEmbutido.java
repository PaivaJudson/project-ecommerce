package com.judsonpaiva.ecommerce.mapeamentobasico;

import com.judsonpaiva.ecommerce.EntityManagerTest;
import com.judsonpaiva.projectecommerce.model.EnderecoEntregaPedido;
import com.judsonpaiva.projectecommerce.model.Pedido;
import com.judsonpaiva.projectecommerce.model.StatusPedido;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjectoEmbutido extends EntityManagerTest {

    @Test
    public void analisarMapeamentoObjectoEmbutido(){

        EnderecoEntregaPedido enderecoEntregaPedido = new EnderecoEntregaPedido();
        enderecoEntregaPedido.setBairro("Golf");
        enderecoEntregaPedido.setCidade("Luanda");
        enderecoEntregaPedido.setLogradouro("Rua das Laranjeiras");
        enderecoEntregaPedido.setNumero("123");
        enderecoEntregaPedido.setEstado("Luanda");

        Pedido pedido = new Pedido();
        //pedido.setId(1);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal(1000));
        pedido.setEnderecoEntrega(enderecoEntregaPedido);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

    }

}
