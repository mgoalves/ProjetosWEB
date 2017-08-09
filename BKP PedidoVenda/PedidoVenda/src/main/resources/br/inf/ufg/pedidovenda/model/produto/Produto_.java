package br.inf.ufg.pedidovenda.model.produto;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-07-20T10:05:47.887-0300")
@StaticMetamodel(Produto.class)
public class Produto_ {
	public static volatile SingularAttribute<Produto, Long> id;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, String> sku;
	public static volatile SingularAttribute<Produto, BigDecimal> valorUnitario;
	public static volatile SingularAttribute<Produto, Integer> quantidadeEstoque;
	public static volatile SingularAttribute<Produto, Categoria> categoria;
}
