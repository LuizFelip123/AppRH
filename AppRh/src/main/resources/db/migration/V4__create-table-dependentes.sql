CREATE TABLE dependentes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_nascimento VARCHAR(255),
    funcionario_id BIGINT,
    CONSTRAINT fk_funcionario
        FOREIGN KEY (funcionario_id) 
        REFERENCES funcionarios(id) 
        ON DELETE CASCADE
);
