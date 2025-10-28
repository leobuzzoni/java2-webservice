INSERT INTO EMPRESA (id, nome, cnpj, email) VALUES (1, 'Empresa Alfa LTDA', '12.345.678/0001-90', 'contato@empresa-alfa.com');
INSERT INTO EMPRESA (id, nome, cnpj, email) VALUES (2, 'Beta Comércio ME', '98.765.432/0001-10', 'beta@comercio.com');
INSERT INTO EMPRESA (id, nome, cnpj, email) VALUES (3, 'Gamma Serviços S.A.', '11.222.333/0001-44', 'servicos@gamma.com');
INSERT INTO EMPRESA (id, nome, cnpj, email) VALUES (4, 'Delta Engenharia', '22.333.444/0001-55', 'contato@deltaeng.com');
INSERT INTO EMPRESA (id, nome, cnpj, email) VALUES (5, 'Epsilon Digital', '33.444.555/0001-66', 'email@epsilondigital.com');

INSERT INTO ESTUDANTE (id, nome, email, nascimento, ano_ingresso) VALUES (1, 'Ana Paula Souza', 'ana.souza@email.com', '2002-03-15', 2020);
INSERT INTO ESTUDANTE (id, nome, email, nascimento, ano_ingresso) VALUES (2, 'Carlos Henrique Lima', 'carlos.lima@email.com', '2001-10-22',
                                                        2019);
INSERT INTO ESTUDANTE (id, nome, email, nascimento, ano_ingresso) VALUES (3, 'Fernanda Oliveira', 'fernanda.oliveira@email.com', '2003-07-05',
                                                        2021);
INSERT INTO ESTUDANTE (id, nome, email, nascimento, ano_ingresso) VALUES (4, 'Lucas Pereira', 'lucas.pereira@email.com', '2002-04-11', 2020);
INSERT INTO ESTUDANTE (id, nome, email, nascimento, ano_ingresso) VALUES (5, 'Gabriela Martins', 'gabriela.martins@email.com', '2001-12-25',
                                                        2019);
INSERT INTO ESTUDANTE (id, nome, email, nascimento, ano_ingresso) VALUES (6, 'Rafael Costa', 'rafael.costa@email.com', '2000-09-13', 2018);
INSERT INTO ESTUDANTE (id, nome, email, nascimento, ano_ingresso) VALUES (7, 'Juliana Silva', 'juliana.silva@email.com', '2002-06-18', 2020);
INSERT INTO ESTUDANTE (id, nome, email, nascimento, ano_ingresso) VALUES (8, 'Marcos Vinícius', 'marcos.vinicius@email.com', '2003-01-30',
                                                        2021);
INSERT INTO ESTUDANTE (id, nome, email, nascimento, ano_ingresso) VALUES (9, 'Camila Azevedo', 'camila.azevedo@email.com', '2001-11-08',
                                        2019);
INSERT INTO ESTUDANTE (id, nome, email, nascimento, ano_ingresso) VALUES (10, 'Felipe Cardoso', 'felipe.cardoso@email.com', '2000-08-27',
                                        2018);

INSERT INTO VAGA (id, titulo, descricao, publicacao, ativo, empresa_id) VALUES (1, 'Desenvolvedor Java', 'Atuação em projetos backend com Java e Spring. Experiência desejada em APIs REST.', '2025-10-01', true, 1);
INSERT INTO VAGA (id, titulo, descricao, publicacao, ativo, empresa_id) VALUES (2, 'Analista de Suporte Técnico', 'Suporte a clientes, resolução de chamados e participação em treinamentos internos.', '2025-09-27', true, 2);
INSERT INTO VAGA (id, titulo, descricao, publicacao, ativo, empresa_id) VALUES (3, 'Engenheiro de Software', 'Desenvolvimento de soluções para sistemas corporativos, integração e automação.', '2025-10-03', false, 3);
INSERT INTO VAGA (id, titulo, descricao, publicacao, ativo, empresa_id) VALUES (4, 'Analista de Dados', 'Manipulação e análise de grandes volumes de dados. Conhecimentos de SQL e Python.', '2025-09-18', true, 4);
INSERT INTO VAGA (id, titulo, descricao, publicacao, ativo, empresa_id) VALUES (5, 'Designer Digital', 'Criação de materiais gráficos, UX/UI e participação em campanhas de marketing.', '2025-09-30', false, 5);
INSERT INTO VAGA (id, titulo, descricao, publicacao, ativo, empresa_id) VALUES (6, 'Consultor de Projetos', 'Elaboração e acompanhamento de projetos empresariais e treinamentos.', '2025-10-06', true, 1);
INSERT INTO VAGA (id, titulo, descricao, publicacao, ativo, empresa_id) VALUES (7, 'Programador Full Stack', 'Desenvolvimento de aplicações web frontend e backend com foco em automação.', '2025-10-04', true, 2);