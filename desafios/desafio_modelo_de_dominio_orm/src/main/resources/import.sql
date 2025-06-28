-- PARTICIPANTES
INSERT INTO tb_participante (id, nome, email) VALUES (1, 'João Silva', 'joao@email.com');
INSERT INTO tb_participante (id, nome, email) VALUES (2, 'Maria Souza', 'maria@email.com');

-- ATIVIDADES
INSERT INTO tb_atividade (id, nome, descricao, preco) VALUES (1, 'Curso de HTML', 'Curso básico de HTML5', 100.00);
INSERT INTO tb_atividade (id, nome, descricao, preco) VALUES (2, 'Oficina de Git', 'Aprenda a usar Git e GitHub', 80.00);

-- BLOCOS (usando Instant com formato ISO-8601)
INSERT INTO tb_bloco (id, dia, horario_inicio, horario_fim, atividade_id)
VALUES (1, TIMESTAMP WITH TIME ZONE '2025-07-01T00:00:00Z', TIMESTAMP WITH TIME ZONE '2025-07-01T08:00:00Z', TIMESTAMP WITH TIME ZONE '2025-07-01T10:00:00Z', 1);

INSERT INTO tb_bloco (id, dia, horario_inicio, horario_fim, atividade_id)
VALUES (2, TIMESTAMP WITH TIME ZONE '2025-07-02T00:00:00Z', TIMESTAMP WITH TIME ZONE '2025-07-02T08:00:00Z', TIMESTAMP WITH TIME ZONE '2025-07-02T10:00:00Z', 1);

INSERT INTO tb_bloco (id, dia, horario_inicio, horario_fim, atividade_id)
VALUES (3, TIMESTAMP WITH TIME ZONE '2025-07-01T00:00:00Z', TIMESTAMP WITH TIME ZONE '2025-07-01T14:00:00Z', TIMESTAMP WITH TIME ZONE '2025-07-01T16:00:00Z', 2);

-- RELACIONAMENTO PARTICIPANTE <-> ATIVIDADE
INSERT INTO atividade_participante (atividade_id, participante_id) VALUES (1, 1);
INSERT INTO atividade_participante (atividade_id, participante_id) VALUES (1, 2);
INSERT INTO atividade_participante (atividade_id, participante_id) VALUES (2, 2);
