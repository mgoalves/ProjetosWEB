package br.inf.ufg;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@ViewScoped
@RequestScoped
public class PerfilUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private int cpf;
	private String nome;
	private String telefone;
	private String telefoneComercial;
	private String matricula;
	
	
	public void atualizar() {
		
		System.out.println("Nome: " + this.nome);
		System.out.println("Tel: " + this.telefone);
		System.out.println("TelC: " + this.telefoneComercial);
		System.out.println("Matricula: " + this.matricula);
		System.out.println("CPF: " + this.cpf);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atualizado"));
		
	}

	
	
	//-----------
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
