package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.inf.ufg.pedidovenda.model.produto.Categoria;
import br.inf.ufg.pedidovenda.model.produto.Produto;
import br.inf.ufg.pedidovenda.repository.Categorias;
import br.inf.ufg.pedidovenda.service.CadastroProdutoService;
import br.inf.ufg.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	@Inject
	private Categorias categorias;

	@Inject
	private CadastroProdutoService cadastroProdutoService;

	// Variaveis
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private Categoria categoriaPai;
	private List<Categoria> categoriasRaizes;
	private List<Categoria> subCategorias;

	// Construtor
	public CadastroProdutoBean() {
		limpar();
	}

	/*
	 * Método responsável por assim que for requerida a página de Cadastro de
	 * Produtos, buscar do banco a lista de Categorias Raízes.
	 */
	public void inicializar() {

		 //this.produto = new Produto();
		    if (FacesUtil.isPostNotBack()) {
		        categoriasRaizes = categorias.buscarCategoriasRaizes();
		        if (this.categoriaPai != null) {
		            carregarSubcategorias();
		        }
		    }
	}

	public void carregarSubcategorias() {
		subCategorias = categorias.subCategoriaDe(categoriaPai);
	}

	private void limpar() {

		produto = new Produto();
		categoriaPai = null;
		subCategorias = new ArrayList<>();		
	}

	public void salvar() {

		System.out.println("Categoria: " + this.produto.getCategoria());
		System.out.println("Nome: " + this.produto.getNome());
		
		
		this.produto = cadastroProdutoService.salvar(this.produto);
		limpar();
		FacesUtil.addInfoMessage("Produto salvo com Sucesso.");
	}

	// Getters and Setters -------------------------------------
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		
		this.produto = produto;
		if(this.produto != null) {
			
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}
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

	public List<Categoria> getSubCategorias() {
		return subCategorias;
	}
	
	public boolean isEditando() {
		
		return this.produto.getId() != null;
	}
}