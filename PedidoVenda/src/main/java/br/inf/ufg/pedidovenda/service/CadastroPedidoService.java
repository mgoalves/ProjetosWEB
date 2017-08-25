package br.inf.ufg.pedidovenda.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.inf.ufg.pedidovenda.model.pedido.Pedido;
import br.inf.ufg.pedidovenda.model.pedido.StatusPedido;
import br.inf.ufg.pedidovenda.repository.Pedidos;
import br.inf.ufg.pedidovenda.util.jpa.Transactional;

public class CadastroPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;

	@Transactional
	public Pedido salvar(Pedido pedido) {
		
		if (pedido.isNovo()) {
			
			pedido.setDataCriacao(new Date());
			pedido.setStatus(StatusPedido.ORCAMENTO);
		}
		
		pedido.recalcularValorTotal();
		
		if(pedido.getItens().isEmpty()) {
			
			throw new NegocioException("O pedido deve possuir pelo menos um item.");
		}
		
		if(pedido.isValorTotalNegativo()){
			
			throw new NegocioException("Valor Total não pode ser negativo.");
		}
		
		pedido = this.pedidos.guardar(pedido);
		return pedido;
	}
	
}
