#Criando o banco de dados
create database cadastro 
default character set utf8
default collate utf8_general_ci;

#Excluir tabela
drop table pessoas;


#Excluir tabela verificando se existe a tabela
drop table if exists pessoas;

create table pessoas ( 

#Criando uma tabela com chave primaria e com as contraints definidas
id int NOT NULL auto_increment,
nome varchar(30) not null, 
nascimento date not null,
sexo enum('M','F') not null,
peso decimal (5,2) not null,
altura decimal (3,2) not null,
nascionalidade varchar(30) default 'Brasil',

primary key (id)

) default charset = utf8 Engine=InnoDB;

#Comando para criar uma tabela e verificar se já não existe 
#Uma tabela com aquele para não sobrescrever a já criada
create table if not exists cursos (

nome varchar (30) not null unique, 
descricao text,
carga int unsigned not null ,
totAulas int unsigned not null,
ano year not null default '2016'

) default charset= utf8;

