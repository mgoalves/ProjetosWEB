package br.inf.ufg.pedidovenda.controller;

import br.inf.ufg.pedidovenda.model.produto.Categoria;
import br.inf.ufg.pedidovenda.model.produto.Produto;
import javax.annotation.Generated;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-08-09T09:07:15.558-0300")
@StaticMetamodel(CadastroProdutoBean.class)
public class CadastroProdutoBean_ {
	public static volatile SingularAttribute<CadastroProdutoBean, Produto> produto;
	public static volatile ListAttribute<CadastroProdutoBean, Categoria> categoriasRaizes;
	public static volatile SingularAttribute<CadastroProdutoBean, EntityManager> manager;
}
