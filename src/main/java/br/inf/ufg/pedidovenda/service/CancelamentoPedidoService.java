package br.inf.ufg.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.inf.ufg.pedidovenda.model.pedido.Pedido;
import br.inf.ufg.pedidovenda.model.pedido.StatusPedido;
import br.inf.ufg.pedidovenda.repository.Pedidos;
import br.inf.ufg.pedidovenda.util.jpa.Transactional;

public class CancelamentoPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;
	@Inject
	private EstoqueService estoqueService;

	@Transactional
	public Pedido cancelar(Pedido pedido) {

		pedido = this.pedidos.buscarPorId(pedido.getId());

		if (pedido.isNaoCancelavel()) {

			throw new NegocioException(
					"Pedido não pode ser cancelado com o status " + 
							pedido.getStatus().getDescricao() + ".");

		} 
		if (pedido.isEmitido()) {
			
			this.estoqueService.retornarItensEstoque(pedido);

		}
		pedido.setStatus(StatusPedido.CANCELADO);
		
		pedido = this.pedidos.guardar(pedido);

		return pedido;
	}

}
