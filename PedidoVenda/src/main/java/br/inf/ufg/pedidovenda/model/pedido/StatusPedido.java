package br.inf.ufg.pedidovenda.model.pedido;

public enum StatusPedido {

	ORCAMENTO("Orçamento"), 
	EMITIDO("Emitido"), 
	CANCELADO("Cancelado");
	
	private String descricao;

	//Construtor
	private StatusPedido(String descricao) {
		this.descricao = descricao;
	}

	//Get
	public String getDescricao() {
		return descricao;
	}
	
}
