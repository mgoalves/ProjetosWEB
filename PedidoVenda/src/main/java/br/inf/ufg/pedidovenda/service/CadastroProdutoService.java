package br.inf.ufg.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.inf.ufg.pedidovenda.model.produto.Produto;
import br.inf.ufg.pedidovenda.repository.Produtos;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;
	
	
	public Produto salvar(Produto produto) {
		
		return produtos.guardar(produto);
	}

}
