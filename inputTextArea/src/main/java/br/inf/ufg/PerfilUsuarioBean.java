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
@RequestScoped
@ViewScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String descricao;

	public void atualizar() {

		System.out.println("Nome: " + this.nome + "\n\nDescrição: " + this.descricao);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login Realizado com sucesso."));

	}
//*	
	public List<String> completarTexto(String consulta) {
		List<String> resultados = new ArrayList<String>();
		
		if (consulta.startsWith("c") || consulta.startsWith("C")) {
			resultados.add("Cirurgião");
			resultados.add("Clinico");

		}
		
		return resultados;
	}
//*/
	//Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
