package br.inf.ufg;

import java.io.Serializable;
import java.util.Date;

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

	// All code

	private String nome;
	private Date dataNascimento;

	public void atualizar() {

		System.out.println("Nome: " + this.nome + "\n\nData de Nascimento: " + this.dataNascimento);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil Atualizado!"));
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nome: " + this.nome + "\n\nData de Nascimento: " + this.dataNascimento));

	}
	
	public Date getDataHoje() {
		
		return new Date();
	}

	// Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
