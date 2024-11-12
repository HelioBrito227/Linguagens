CREATE TABLE linguagem(
	sequencial int NOT NULL auto_increment,
	nome VARCHAR(60) NOT NULL,
	tipo VARCHAR(60) NOT NULL,
	data_criacao DATE NOT null,
	descricao VARCHAR(80),
	PRIMARY KEY(sequencial)
);