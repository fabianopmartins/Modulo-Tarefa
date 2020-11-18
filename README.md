# Modulo-Tarefa

# Script de criação do banco de dados

CREATE DATABASE mensagex;

USE mensagex;

CREATE TABLE usuario(
id INT AUTO_INCREMENT,
nome VARCHAR(150) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
senha VARCHAR(20) NOT NULL,
PRIMARY KEY (id)
) ENGINE = INNODB;

CREATE TABLE tarefa(
id INT AUTO_INCREMENT,
titulo VARCHAR(30) NOT NULL,
dataTarefa DATE,
usuario_id INT NOT NULL,
PRIMARY KEY (id)
) ENGINE = INNODB;

ALTER TABLE `tarefa` ADD CONSTRAINT `fk_tarefa_usuario` FOREIGN KEY (`usuario_id`)
REFERENCES `usuario` (`id`);

## ULR inicial

http://localhost:8080/Mensagex/usuarioController?action=listaUsuario
