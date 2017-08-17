package br.inf.ufg.pedidovenda.repository;

import java.io.Serializable;
import java.util.Date;

import br.inf.ufg.pedidovenda.model.pedido.StatusPedido;

public class PedidoFilter implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	//Variavéis
	private long numeroDe;
	private long numeroAte;
	private Date dataCriacaoDe;
	private Date dataCriacaoAte;
	private String nomeVendedor;
	private String nomeCliente;
	private StatusPedido[] status;
	
	//Getters and Setters
	public long getNumeroDe() {
		return numeroDe;
	}
	public void setNumeroDe(long numeroDe) {
		this.numeroDe = numeroDe;
	}
	public long getNumeroAte() {
		return numeroAte;
	}
	public void setNumeroAte(long numeroAte) {
		this.numeroAte = numeroAte;
	}
	public Date getDataCriacaoDe() {
		return dataCriacaoDe;
	}
	public void setDataCriacaoDe(Date dataCriacaoDe) {
		this.dataCriacaoDe = dataCriacaoDe;
	}
	public Date getDataCriacaoAte() {
		return dataCriacaoAte;
	}
	public void setDataCriacaoAte(Date dataCriacaoAte) {
		this.dataCriacaoAte = dataCriacaoAte;
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public StatusPedido[] getStatus() {
		return status;
	}
	public void setStatus(StatusPedido[] status) {
		this.status = status;
	}
}
