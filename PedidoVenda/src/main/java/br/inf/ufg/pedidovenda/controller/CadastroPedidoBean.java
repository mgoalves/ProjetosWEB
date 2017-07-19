package br.inf.ufg.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.inf.ufg.pedidovenda.service.NegocioException;

@Named
@RequestScoped
public class CadastroPedidoBean {

	private List<Integer> itens;
	
	public CadastroPedidoBean() {
		
		itens = new ArrayList<>();
		itens.add(1);
	}
	
	public List<Integer> getItens() {	
		return itens;
	}
	
	public void salvar(){
		throw new NegocioException("Não implementado.");
	}

}
