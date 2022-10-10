CREATE DATABASE RFPROD;

USE RFPROD;

CREATE TABLE processo (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(45) NOT NULL
);

INSERT INTO
	processo
VALUES
	(1,'Laminação'),
	(2,'Trefilação'),
	(3,'Encordoamento'),
	(4,'Extrusão'),
	(5,'Controle de Qualidade'),
	(6,'Corte e Embalagem');

CREATE TABLE maquina (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(45) NOT NULL,
	numeracao VARCHAR(10) NOT NULL,
	descricao VARCHAR(100) NOT NULL,
	id_processo INT NOT NULL,
	FOREIGN KEY (id_processo) REFERENCES processo (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

INSERT INTO
	maquina
VALUES
	(1,'Laminadora de Chapas Grossas','LMD-001','Laminadora de chapas grossas p/ fios de cobre e alumínio 15CV',1),
	(2,'Máquina de Fundição Contínua','MFC-001','Máquina de fundição contínua p/ barras de cobre modelo Smather',1),
	(3,'Laminadora de Alumínio (frio)','LMD-002','Laminadora de Alumínio (frio) com motor de 80cv',1),
	(4,'Trefila Horizontal Multifilar','TRF-001','Trefila horizontal multifilar modelo Raichbech 8 fios',2),
	(5,'Trefila Multifilar Multimotores','TRF-002','Trefila multifilar multimotores modelo Raichbech 18 fios',2),
	(6,'Trefila de Vergalhão de Cobre','TRF-003','Trefila de vergalhão de cobre Raichbech',2),
	(7,'Cordeira Tubular Rígida','TUB-001','Cordeira tubular rígida max. 72 bobinas modelo SHT 500',3),
	(8,'Cordeira Tubular de 7 fios','TUB-002','Cordeira tubular de 7 fios automática modelo SHT 720',3),
	(9,'Cordeira Tubular Rígida','TUB-003','Cordeira tubular rígida max. 62 bobinas modelo QTR 420',3),
	(10,'Extrusora Moitto','EXT-001','Extrusora Moitto 120mm linha de encapamento de fios e cabos',4),
	(11,'Extrusora Dupla Masterflex','EXT-002','Extrusora dupla Masterflex p/ cobre e alumínio',4),
	(12,'Extrusora Raifeniet','EXT-003','Extrusora Raifeniet modelo 300mm',4),
	(13,'Máquina Full','MCQ-001','Maquina para teste de sobrecarga modelo Full',5),
	(14,'Máquina Scaltech','CSK-001','Máquina de corte e embalagem modelo Scaltech E40 PRO',6),
	(15,'Máquina Scaltech','CSK-002','Máquina de corte e embalagem modelo Scaltech E40 PRO',6),
	(16,'Máquina Scaltech','CSK-003','Máquina de corte e embalagem modelo Scaltech E80 PRO',6);

CREATE TABLE funcionario (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(45) NOT NULL,
	sobrenome VARCHAR(45) NOT NULL,
	data_nascimento DATE NOT NULL,
	cpf VARCHAR(14) NOT NULL UNIQUE,
	celular VARCHAR(15) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	endereco VARCHAR(150) NOT NULL,
	salario DECIMAL(7, 2) NOT NULL,
	id_maquina INT NOT NULL,
	FOREIGN KEY (id_maquina) REFERENCES maquina (id)
);

INSERT INTO
	funcionario
VALUES
	(1,'Luan','Tomás Bruno Caldeira','1967-06-15','910.942.428-88','(61) 98796-0504','luan-caldeira78@lidertel.com.br','Avenida Santo Pelozio - Jardim das Azaléias - 756',2500.00,1),
	(2,'Nelson','Joaquim Iago Sales','1970-07-13','017.288.748-81','(19) 98879-1618','nelson-sales82@abrangencia.com.br','Rua Doutor Romeu Furlanetto - Jardim Satélite - 873',2300.00,2),
	(3,'Pedro','Castro da Luzz','1974-07-02','319.331.008-78','(19) 98676-9374','pedro-daluz1292@techdomus.com.br','Rua Luís Vaz de Camões - Vila Brasil - 189',2200.00,3),
	(4,'Sérgio','Hugo Isaac Pereira','1968-04-08','926.650.188-37','(19) 98821-6615','sergio-pereira12212@carreiradasilva.com','Rua Walter Adolpho Simon - Jardim Nova República (3ª Etapa) - 705',2300.00,4),
	(5,'Gustavo','Heitor Anthony Silveira','1976-04-15','413.219.268-72','(19) 99774-1161','gustavoheitorsilveira123@accardoso.com.br','Rua José Cuqui - Jardim Primeiro de Maio - 668',2700.00,5),
	(6,'Arthur','Calebe Silva','1974-08-28','511.066.168-55','(19) 99340-9391','arthurferreira123@ravi.com.br','Rua Samuel Hanemann - Jardim Santo André - 283',2500.00,6),
	(7,'Kaique','Pedro Rodrigues','1963-02-11','356.197.268-93','(19) 98655-9591','kaique.rodrigues123@lubeka.com.br','Rua Alfredo Ansani - Jardim São Thiago - 650',2400.00,7),
	(8,'Luiz','Gael Luís Ribeiro','1988-08-12','178.492.818-96','(19) 99828-5217','luiz_11ribeiro@poli.ufrj.br','Rua Evaristo da S. Castro - Solário da Mantiqueira - 358',2600.00,8),
	(9,'Marcos','Vinicius Geraldo da Paz','1954-04-22','664.721.458-57','(19) 99369-2233','marcos.vinicius2223@s2solucoes.com.br','Rua Basilidio L. de Campos - Jardim Guanabara - 660',2200.00,9),
	(10,'Joaquim','Renato Diogo das Neves','1993-12-29','573.611.028-83','(19) 99949-1690','joaq1mrenatodasneve123s@yaooll.com','Rua Gabriel Pio Loyola - Vila Loyola - 784',2800.00,10),
	(11,'Luiz','Juan Martins','1983-04-19','312.325.081-10','(19) 98110-7480','luiz_martins123q@sigtechbr.com','Rua Maximiano Salomão - Núcleo Residencial Durval Nicolau 3 - 489',2600.00,11),
	(12,'Carlos','Enzo Kauê Lima','2000-09-12','877.958.998-70','(19) 99391-9751','carlosenzolima123@skapcom.com.br','Rua Liberato S. Galli - Santo Antônio - 134',2100.00,12),
	(13,'Davi','Gael Rodrigo da Mota','1979-08-03','844.563.478-05','(19) 99380-5243','davi_gael_qdota123@ciroconsultoria.com.br','Rua Manoel Luiz Ribeiro - Jardim Primeiro de Maio - 582',2300.00,13),
	(14,'Edson','Kauê Cavalcanti','2001-03-10','565.387.268-79','(19) 99599-3138','edson-cavalcanti9233@zf.com','Rua Manoel Pedro Rodrigues - Jardim Novo Horizonte - 945',1800.00,14),
	(15,'Pedro','Henrique Breno Caldeira','1978-05-25','379.951.218-98','(19) 98674-1157','pedro-cald1ira99@directnet.com','Avenida Rodrigues Alves - Jardim Santo André - 219',2000.00,15),
	(16,'Nelson','Edson Gael Almeida','1065-09-13','744.451.308-26','(19) 99655-0825','nelsonedsonalmeida123@caperfeicoamento.com.br','Rua Itália Bovo - Núcleo Residencial Durval Nicolau 3 - 244',2000.00,16),
	(17,'Victor','Joaquim Santos Almeida','1987-03-29','113.150.938-72','(19) 99976-2750','victorsantos_almeida456@bwmtrade.com','Rua João Cristiano Luhmann - Jardim Primeiro de Maio - 757',2600.00,6),
	(18,'Benjamin','Yuri Viana','2002-03-22','014.511.298-52','(19) 98998-3099','benjamin1345viana@biconsult.com.br','Rua Padre Irineu - Jardim Bela Vista - 311',2500.00,7),
	(19,'Eduardo','Luan Luiz Corte Real','1988-08-11','285.445.768-42','(19) 98776-7746','eduardocorteral90@freitasprior.com.br','Rua Doutor José Osório de Oliveira Azevedo - Alto da Boa Vista - 663',2700.00,14),
	(20,'Daniel','Iago Moural','1966-03-28','098.056.478-62','(19) 99272-6488','dan2435ura@andrepires.com.br','Rua Maria Aparecida Lisboa - Jardim Recanto do Jaguari - 882',2200.00,3),
	(21,'Davi','Vicente Drumond','1994-07-27','006.042.848-10','(19) 99820-3770','davi43535mond@ruizonline.com.br','Rua Irmãs Caritas 310 - Vila Carvalho - 351',2500.00,5);

CREATE TABLE produto (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(45) NOT NULL,
	categoria VARCHAR(30) NOT NULL,
	classe VARCHAR(15) NOT NULL,
	condutores INT NOT NULL,
	bitola DECIMAL(5, 2) NOT NULL,
	cor VARCHAR(20) NOT NULL
);

INSERT INTO
	produto
VALUES
	(1,'Cabo Rígido 750V','Cabo Rígido','Classe 2',1,10.00,'Verde'),
	(2,'Cabo Rígido HEPR 1kV','Cabo Rígido','Classe 2',1,16.00,'Azul'),
	(3,'Cabo Rígido HEPR 1kV','Cabo Rígido','Classe 2',1,70.00,'Preto'),
	(4,'Cabo Flexível 750V','Cabo Flexível','Classe 5',1,1.00,'Amarelo'),
	(5,'Cabo Flexível 750V','Cabo Flexível','Classe 5',1,25.00,'Azul'),
	(6,'Cabo Flexível PP 500V','Cabo PP','Classe 5',2,1.00,'Preto'),
	(7,'Cabo Flexível PP 500V','Cabo PP','Classe 5',2,6.00,'Preto'),
	(8,'Cabo Flexível PP 500V','Cabo PP','Classe 5',4,10.00,'Preto'),
	(9,'Cabo Flexível HEPR 1kV','Cabo HEPR','Classe 5',1,25.00,'Verde'),
	(10,'Cabo Flexível HEPR 1kV','Cabo HEPR','Classe 5',1,185.00,'Azul'),
	(11,'Cordão Flexível Paralelo 300V','Cordão Paralelo','Classe 5',2,4.00,'Marrom'),
	(12,'Cordão Flexível Paralelo 300V','Cordão Paralelo','Classe 5',2,2.50,'Branco'),
	(13,'Cordão Flexível Torcido 300V','Cordão Torcido','Classe 5',2,4.00,'Branco'),
	(14,'Cordão Flexível Torcido 300V','Cordão Torcido','Classe 5',2,1.00,'Branco'),
	(15,'Cabo Fotovoltaico 1.8kV','Classe 5','Classe 5',1,4.00,'Vermelho');

CREATE TABLE ordem_producao (
	id INT PRIMARY KEY AUTO_INCREMENT,
	data_criacao DATE NOT NULL,
	data_inicio DATE NOT NULL,
	data_fim DATE NOT NULL,
	status VARCHAR(15) NOT NULL
);

INSERT INTO
	ordem_producao
VALUES
	(1,'2022-08-14','2022-08-14','2022-09-30','Em Produção'),
	(2,'2022-08-14','2022-08-14','2022-08-20','Em Produção'),
	(3,'2022-08-14','2022-08-14','2022-08-14','Não Iniciado');

CREATE TABLE item_ordem_producao (
	id INT PRIMARY KEY AUTO_INCREMENT,
	quantidade INT NOT NULL,
	id_produto INT NOT NULL,
	id_ordem_producao INT NOT NULL,
	FOREIGN KEY (id_produto) REFERENCES produto (id),
	FOREIGN KEY (id_ordem_producao) REFERENCES ordem_producao (id)
);

INSERT INTO
	item_ordem_producao
VALUES
	(1,80,1,1),
	(2,50,9,1),
	(3,30,13,1),
	(4,50,7,2),
	(5,60,15,2),
	(6,100,4,2);

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

INSERT INTO
	apontamento
VALUES
	(1,'2022-08-14','04:20:00','13:40:00',7,1),
	(2,'2022-08-14','04:20:00','13:40:00',4,1),
	(3,'2022-08-14','04:20:00','13:40:00',11,1),
	(4,'2022-08-14','13:40:00','22:00:00',14,2),
	(5,'2022-08-14','13:40:00','22:00:00',9,2),
	(6,'2022-08-14','13:40:00','22:00:00',12,2);
