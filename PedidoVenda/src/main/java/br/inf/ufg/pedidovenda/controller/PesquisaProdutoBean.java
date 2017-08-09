package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Integer> produtosFiltrados;

	public PesquisaProdutoBean() {

		produtosFiltrados = new ArrayList<>();

		for (int i = 0; i < 50; i++) {

			produtosFiltrados.add(i);
			
		}
	}
	
	public List<Integer> getProdutoFiltrados() {

		return produtosFiltrados;
	}
}
