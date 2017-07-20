package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CadastroProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	public void salvar(){
		throw new RuntimeException("Erro ao salvar");
	}
	
}
