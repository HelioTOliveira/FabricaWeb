--criar banco

create dabase fabicaWeb;

--escolher o banco para trabalhar
use fabicaWeb;

-- criar tabela de usuario

create table usuario(
id_usuario 			    int AUTOMATIC,
nome 		not null	varchar (100),
login		not null	varchar (30),
senha       not null	varchar (32),
primary key(id_usuario)
);

-- inserir na tabela usuario 
insert into usuario (nome, login, senha) 
VALUES ('jão', 'jjj','123'),
('Maria', 'mar','123456'),
('jose', 'jose','567');