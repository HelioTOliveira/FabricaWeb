-- criar banco
create database fabricaWeb;

-- usuar o banco fabricaWeb
use fabricaWeb;

-- criar tabela de usuario

create table usuario(
id_usuario 		    int auto_increment,
nome 		 varchar(100) not null,
login		 varchar (30) not null,
senha        varchar (32) not null,
primary key(id_usuario)
);

-- inserir na tabela usuario 
insert into usuario (nome, login, senha) 
VALUES ('JAOA', 'jjj','123'),
('Maria', 'mar','123456'),
('jose', 'jose','567');
