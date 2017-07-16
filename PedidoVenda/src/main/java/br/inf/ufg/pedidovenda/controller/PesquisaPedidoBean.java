package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
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
