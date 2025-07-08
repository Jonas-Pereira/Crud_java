create database bancoteste;

use bancoteste;

create table Funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_funcionario VARCHAR(100),
    endereco_funcionario VARCHAR(100),
	email VARCHAR(100)
);

show tables;
select * from Funcionario;