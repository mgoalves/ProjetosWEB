/*Aula de Inserção #05 Gustavo Guanabara*/


/*Exemplo sem as caracteristicas do banco*/
insert into pessoas
values
('Marcello', '1997-03-17', 'M', '78.5', '1.87', 'Brasil');

/*Retorna todas as tuplas da tabela*/
select * from pessoas;


/*Exemplo de Inserção Multipla*/
insert into pessoas 
(nome, nascimento, sexo, peso, altura, nascionalidade)
 values
 ('Marcello', '1997-03-17', 'M', '80', '1.81', 'Brasil'),
 ('Ludmilla', '1997-05-05', 'F', '60', '1.75', default);