package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.inf.ufg.pedidovenda.model.pedido.Pedido;
import br.inf.ufg.pedidovenda.model.pedido.StatusPedido;
import br.inf.ufg.pedidovenda.repository.PedidoFilter;
import br.inf.ufg.pedidovenda.repository.Pedidos;

@Named
@ViewScoped
public class PesquisaPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;

	//Variavéis
	private List<Pedido> pedidosFiltrados;
	private PedidoFilter filter;



	public PesquisaPedidoBean() {
		
		filter = new PedidoFilter();
		pedidosFiltrados = new ArrayList<>();
	}
	
	public void pesquisar() {
		pedidosFiltrados =  pedidos.filtrados(filter);
		
	}
	
	public StatusPedido[] getStatus() {
		
		return StatusPedido.values();
	}
	
	
	//Getters and Setters
	public List<Pedido> getPedidosFiltrados() {
		
		return pedidosFiltrados;
	}
	public PedidoFilter getFilter() {
		return filter;
	}

}
