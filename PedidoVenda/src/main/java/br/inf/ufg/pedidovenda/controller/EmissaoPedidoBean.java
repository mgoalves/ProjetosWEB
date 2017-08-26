package br.inf.ufg.pedidovenda.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.inf.ufg.pedidovenda.model.pedido.Pedido;
import br.inf.ufg.pedidovenda.service.EmissaoPedidoService;
import br.inf.ufg.pedidovenda.util.jsf.FacesUtil;
import br.inf.ufg.pedidovenda.validation.PedidoEdicao;

@Named
@ViewScoped
public class EmissaoPedidoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmissaoPedidoService emissaoPedidoService;
	
	@Inject
	@PedidoEdicao
	private Pedido pedido;
	
	public void emitirPedido() {
		this.pedido.removerItemVazio();
		
		try {
			
			this.pedido = this.emissaoPedidoService.emitir(this.pedido);
			
			FacesUtil.addInfoMessage("Pedido emitido com sucesso.");
			
		} finally {
			
			this.pedido.adicionarItemVazio();
		}
	}

}
