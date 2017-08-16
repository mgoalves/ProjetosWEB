package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.inf.ufg.pedidovenda.model.produto.Produto;
import br.inf.ufg.pedidovenda.repository.ProdutoFilter;
import br.inf.ufg.pedidovenda.repository.Produtos;


@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Inject
	private Produtos produtos;
	
	//Variaveis
	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;

	
	
	public PesquisaProdutoBean() {

		filtro = new ProdutoFilter();
	}


	public void pesquisar() {
		
		produtosFiltrados = produtos.filtrados(filtro);
	}

	
	//Getters and Setters
	public ProdutoFilter getFiltro() {
		return filtro;
	}
	public List<Produto> getProdutoFiltrados() {

		return produtosFiltrados;
	}
}
