package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.inf.ufg.pedidovenda.model.produto.Produto;

@SuppressWarnings("deprecation")
@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Produto produto;
	
	private CadastroProdutoBean(){
		
		produto = new Produto();
		
	}

	public void salvar(){
		
	}

	public Produto getProduto() {
		return produto;
	}
	
	
	
}
