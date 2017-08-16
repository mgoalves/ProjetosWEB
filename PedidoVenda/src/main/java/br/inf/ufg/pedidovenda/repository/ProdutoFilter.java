package br.inf.ufg.pedidovenda.repository;

import java.io.Serializable;

import br.inf.ufg.pedidovenda.validation.SKU;

public class ProdutoFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private String sku;
	private String nome;
	
	
	//Getters and Setters
	@SKU
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
