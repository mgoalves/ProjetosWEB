package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.inf.ufg.pedidovenda.model.produto.Categoria;
import br.inf.ufg.pedidovenda.model.produto.Produto;
import br.inf.ufg.pedidovenda.repository.Categorias;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	@Inject
	private Categorias categorias;

	// Variaveis
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private List<Categoria> categoriasRaizes;
	private Categoria categoriaPai;
	
	// Construtor
	public CadastroProdutoBean() {
		produto = new Produto();
	}

	/*
	 * Método responsável por assim que for requerida a página de Cadastro de
	 * Produtos, buscar do banco a lista de Categorias Raízes.
	 */
	public void inicializar() {
		System.out.println("Inicializando...");
		categoriasRaizes = categorias.buscarCategoriasRaizes();
	}

	public void salvar() {
		
		System.out.println("Categoria pai selecionada: " + categoriaPai.getDescricao());
	}

	// Getters and Setters -------------------------------------
	public Produto getProduto() {
		return produto;
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}
}