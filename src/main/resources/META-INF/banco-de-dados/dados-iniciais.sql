insert into produto (id, nome, preco, descricao) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora...');
insert into produto (id, nome, preco, descricao) values (3, 'Câmera GoPro', 1400.0, 'Desempenho 2x ...');

insert into cliente(id, nome) values (1, 'Judson Paiva');
insert into cliente(id, nome) values (2, 'Leonor José');

insert into pedido (id, cliente_id, data_pedido, total) values (1, 1, sysdate(), 100.0)

insert into item_pedido (id, pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 1, 5.0, 2)