package br.inf.ufg.pedidovenda.model.cliente;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-07-20T08:13:21.947-0300")
@StaticMetamodel(Cliente.class)
public class Cliente_ {
	public static volatile SingularAttribute<Cliente, Long> id;
	public static volatile SingularAttribute<Cliente, String> nome;
	public static volatile SingularAttribute<Cliente, String> email;
	public static volatile SingularAttribute<Cliente, String> docReceitaFederal;
	public static volatile SingularAttribute<Cliente, TipoPessoa> tipo;
	public static volatile ListAttribute<Cliente, Endereco> enderecos;
}
