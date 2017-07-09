/*Aula 06 Guanabara*/

desc cursos;
desc gafanhotos;
select * from cursos;
select * from gafanhotos;


#Como adicionar colunas nas tabelas
alter table pessoas 
add column profissao varchar(10);

#Como remover colunas nas tabelas
alter table pessoas
drop column profissao;

#Como adcionar colunas em lugares especificos
alter table pessoas 
add column profissao varchar(10) not null after nome;

#Não existe o comando BEFORE nem o last

#Para adicionar no primeiro campo já que não existe before, nem after
#para o primeiro pois nao existe nada antes usamos o comando first
alter table pessoas
add column codigo int first;

alter table cursos
add column idCurso int unsigned first;

#Alterando um atributo para chave primaria 
alter table cursos
add primary key(idCurso);


#O comando column não é obrigatório
alter table pessoas 
add profissao varchar(10) not null after nome;

#-----------------------

#Modificando columns, aqui só é possivel alterar as contraints 
#ou seja os dados da colunak
alter table pessoas 
modify column profissao varchar(20);

#Modificando o nome da coluna e as contraints
#Quando for renomear tem que colocar todos os dados iguais já estava
alter table pessoas
change column profissao prof varchar(20);

#Renomear a tabela
alter table pessoas
rename to gafanhotos;



