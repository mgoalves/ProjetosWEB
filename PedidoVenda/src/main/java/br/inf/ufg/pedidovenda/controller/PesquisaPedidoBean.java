package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PesquisaPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integer> pedidosFiltrado;

	public PesquisaPedidoBean() {

		pedidosFiltrado = new ArrayList<>();

		for (int i = 0; i < 50; i++) {

			pedidosFiltrado.add(i);

		}
	}
	
	public List<Integer> getPedidosFiltrado() {
		
		return pedidosFiltrado;
	}

}
