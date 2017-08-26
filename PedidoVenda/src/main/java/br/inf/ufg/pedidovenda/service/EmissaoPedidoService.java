package br.inf.ufg.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.inf.ufg.pedidovenda.model.pedido.Pedido;
import br.inf.ufg.pedidovenda.model.pedido.StatusPedido;
import br.inf.ufg.pedidovenda.repository.Pedidos;

public class EmissaoPedidoService implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Inject
	private CadastroPedidoService cadastroPedidoService;
	@Inject
	private Pedidos pedidos;
	
	public Pedido emitir(Pedido pedido) {
		
		pedido = this.cadastroPedidoService.salvar(pedido);
		
		if(pedido.isNaoEmissivel()) {
			
			throw new NegocioException("Pedido não pode ser emitido com status " + 
										pedido.getStatus().getDescricao() + "."); 
		}
		
		pedido.setStatus(StatusPedido.EMITIDO);
		pedido = this.pedidos.guardar(pedido);
		
		return null;
	}
	
}
