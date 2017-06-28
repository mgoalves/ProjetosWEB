package br.inf.ufg;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
@ViewScoped
public class PerfilUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	
	
	public void atualizar () {
		
		System.out.println("Login: " + this.login + "\nSenha: " + this.senha);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login Realizado com sucesso."));	
		
	}
	
	
	
	//Getters and Setters
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
