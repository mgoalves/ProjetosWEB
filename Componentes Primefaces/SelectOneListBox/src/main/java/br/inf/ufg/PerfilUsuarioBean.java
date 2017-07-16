package br.inf.ufg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
@RequestScoped
public class PerfilUsuarioBean implements Serializable {
	

	private static final long serialVersionUID = 1L;

	public static final List<Interesse> INTERESSES = new ArrayList<>();
	
	static {
		INTERESSES.add(new Interesse("Esportes", "esportes"));
		INTERESSES.add(new Interesse("Computação", "computacao"));
		INTERESSES.add(new Interesse("Cinema", "cinema"));
		INTERESSES.add(new Interesse("Leitura", "leitura"));
	}

	private String nome;
	private String profissao;
	private Interesse interesse;

	public void atualizar() {

		System.out.println("Nome: " + this.nome + "\nProfissão: " + this.profissao);
		System.out.println("Interesse: " + this.interesse.getDescricao() + 
				"\nNome Icone: " + this.interesse.getNomeIcone());

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));

	}
	
	public List<Interesse> getInteresses() {
		return INTERESSES;
	}
	
	// Getters and Setters
	public String getNome() {
		return nome;
	}

	public Interesse getInteresse() {
		return interesse;
	}

	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}
