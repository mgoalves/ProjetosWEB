package br.inf.ufg.pedidovenda.controller;

import br.inf.ufg.pedidovenda.model.pedido.Pedido;

public class PedidoAlteradoEvent {

	private Pedido pedido;
	
	public PedidoAlteradoEvent(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}
	
}
