/*Aula de Inserção #05 Gustavo Guanabara*/

insert into pessoas
values
('11510099999', 'Marcello', '1997-03-17', 'M', '78.5', '1.87', 'Brasil');
select * from pessoas;


/*Exemplo de Inserção Multipla*/
insert into pessoas 
(cpf, nome, nascimento, sexo, peso, altura, nascionalidade)
 values
 ('11510087613', 'Marcello', '1997-03-17', 'M', '80', '1.81', 'Brasileiro'),
 ('11510087613', 'Marcello', '1997-03-17', 'M', '80', '1.81', 'Brasileiro');