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
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String sexo;
	private String estadoCivil;
	
	public void atualizar () {
		
		System.out.println("N: "  + this.nome + "\nS: " + this.sexo + "\nE: " + this.estadoCivil);
		
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atualizado"));	
		
	}

	
	//------------------------
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	
	

}
