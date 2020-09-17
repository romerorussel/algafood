INSERT INTO cozinha (id, nome) VALUES (1, "Tailandesa");
INSERT INTO cozinha (id, nome) VALUES (2, "Indiana");
INSERT INTO cozinha (id, nome) VALUES (3, "Brasileira");

INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ("Restaurante 1", 3.9, 1);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ("Restaurante 2", 7.5, 1);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ("Restaurante 3", 10.5, 3);

INSERT INTO estado(id, nome) VALUES (1, "Pernambuco");
INSERT INTO estado(id, nome) VALUES (2, "São Paulo");
INSERT INTO estado(id, nome) VALUES (3, "Rio Grande do Sul");

INSERT INTO cidade(id, nome, estado_id) VALUES (1, "Recife", 1);
INSERT INTO cidade(id, nome, estado_id) VALUES (2, "Guarulhos", 2);
INSERT INTO cidade(id, nome, estado_id) VALUES (3, "Porto Alegre", 3);

INSERT INTO forma_pagamento(id, descricao) VALUES (1, "Dinheiro");
INSERT INTO forma_pagamento(id, descricao) VALUES (2, "Cartão de Crédito");
INSERT INTO forma_pagamento(id, descricao) VALUES (3, "Transferência Bancária");

INSERT INTO PERMISSAO (id, nome, descricao) VALUES (1, "CONSULTAR_COZINHAS", "Permite consultar cozinhas");
INSERT INTO PERMISSAO (id, nome, descricao) VALUES (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');