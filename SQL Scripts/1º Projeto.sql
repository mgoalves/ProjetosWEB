create database cadastro 
default character set utf8
default collate utf8_general_ci;

drop table pessoas;

create table pessoas ( 

id int NOT NULL auto_increment,
cpf varchar(11) not null,
nome varchar(30) not null, 
nascimento date not null,
sexo enum('M','F') not null,
peso decimal (5,2) not null,
altura decimal (3,2) not null,
nascionalidade varchar(30) default 'Brasil',

primary key (id)

) default charset = utf8 Engine=InnoDB;



/*Teste de inserção//*/
insert into pessoas (cpf, nome, nascimento, sexo, peso, altura, nascionalidade)
 values ('11510087613', 'Marcello', '1997-03-17', 'M', '80', '1.81', 'Brasileiro');


drop table pessoas;