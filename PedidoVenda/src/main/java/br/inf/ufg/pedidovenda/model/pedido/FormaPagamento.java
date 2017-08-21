package br.inf.ufg.pedidovenda.model.pedido;

public enum FormaPagamento {

	DINHEIRO("Dinheiro"), 
	CARTAO_CREDITO("Cartão de Crédito"), 
	CARTAO_DEBITO("Cartão de Débito"), 
	CHEQUE("Cheque"), 
	BOLETO_BANCARIO("Boleto Bancário"), 
	DEPOSITO_BANCARIO("Depósito Bancário");
	
	private String descricao;

	
	private FormaPagamento(String descricao) {
	
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
