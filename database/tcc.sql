-- CREATE DATABASE TCC;

CREATE TABLE processo (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(45) NOT NULL
);

CREATE TABLE maquina (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(45) NOT NULL,
	numeracao VARCHAR(10) NOT NULL,
	descricao VARCHAR(45) NOT NULL,
	id_processo INT NOT NULL,
	FOREIGN KEY (id_processo) REFERENCES processo (id)
);

CREATE TABLE funcionario (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(45) NOT NULL,
	sobrenome VARCHAR(45) NOT NULL,
	data_nascimento DATE NOT NULL,
	cpf VARCHAR(14) NOT NULL UNIQUE,
	celular VARCHAR(15) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	endereco VARCHAR(150) NOT NULL,
	salario NUMERIC(6, 2) NOT NULL,
	id_maquina INT NOT NULL,
	FOREIGN KEY (id_maquina) REFERENCES maquina (id)
);

CREATE TABLE produto (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(45) NOT NULL,
	categoria VARCHAR(30) NOT NULL,
	classe VARCHAR(15) NOT NULL,
	bitola DECIMAL NOT NULL,
	cor VARCHAR(20) NOT NULL
);

CREATE TABLE ordem_producao (
	id INT PRIMARY KEY AUTO_INCREMENT,
	data_criacao DATE NOT NULL,
	data_inicio DATE,
	data_fim DATE,
	status VARCHAR(15) NOT NULL
);

CREATE TABLE item_ordem_producao (
	id INT PRIMARY KEY AUTO_INCREMENT,
	quantidade INT NOT NULL,
	id_produto INT NOT NULL,
	id_ordem_producao INT NOT NULL,
	FOREIGN KEY (id_produto) REFERENCES produto (id),
	FOREIGN KEY (id_ordem_producao) REFERENCES ordem_producao (id)
);

CREATE TABLE apontamento (
	id INT PRIMARY KEY AUTO_INCREMENT,
	data_atual DATE NOT NULL,
	hora_inicio TIME NOT NULL,
	hora_fim TIME NOT NULL,
	id_maquina INT NOT NULL,
	id_ordem_producao INT NOT NULL,
	FOREIGN KEY (id_maquina) REFERENCES maquina (id),
	FOREIGN KEY (id_ordem_producao) REFERENCES ordem_producao (id)
);
