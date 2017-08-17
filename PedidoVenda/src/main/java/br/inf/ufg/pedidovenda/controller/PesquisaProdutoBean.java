package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.inf.ufg.pedidovenda.model.produto.Produto;
import br.inf.ufg.pedidovenda.repository.ProdutoFilter;
import br.inf.ufg.pedidovenda.repository.Produtos;
import br.inf.ufg.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;

	// Variaveis
	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;
	private Produto produtoSelecionado;

	// Construtor
	public PesquisaProdutoBean() {

		filtro = new ProdutoFilter();
	}

	// Função que chama a busca dos produtos no banco de dados
	// a partir das restrições inseridas pelo usuario.
	public void pesquisar() {

		produtosFiltrados = produtos.filtrados(filtro);
	}

	public void excluir() {
		produtos.remover(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);

		FacesUtil.addInfoMessage("Produto " + produtoSelecionado.getSku() + " excluído com sucesso.");
	}

	// Getters and Setters
	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public List<Produto> getProdutoFiltrados() {

		return produtosFiltrados;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

}
