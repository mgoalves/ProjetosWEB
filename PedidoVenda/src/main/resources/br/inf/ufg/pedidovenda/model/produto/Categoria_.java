package br.inf.ufg.pedidovenda.model.produto;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-07-20T10:02:17.791-0300")
@StaticMetamodel(Categoria.class)
public class Categoria_ {
	public static volatile SingularAttribute<Categoria, Long> id;
	public static volatile SingularAttribute<Categoria, String> descricao;
	public static volatile SingularAttribute<Categoria, Categoria> categoriaPai;
	public static volatile ListAttribute<Categoria, Categoria> subcategorias;
}
