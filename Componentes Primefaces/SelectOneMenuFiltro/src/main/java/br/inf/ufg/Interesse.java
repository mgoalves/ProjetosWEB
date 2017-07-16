package br.inf.ufg;

import java.io.Serializable;

public class Interesse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private String nomeIcone;

	Interesse() {

	}

	Interesse(String descricao, String nomeIcone) {

		this.descricao = descricao;
		this.nomeIcone = nomeIcone;

	}

	// G and S
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeIcone() {
		return nomeIcone;
	}

	public void setNomeIcone(String nomeIcone) {
		this.nomeIcone = nomeIcone;
	}

}