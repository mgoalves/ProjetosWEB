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

	private String nome;
	private String pais;

	private List<String> paises = new ArrayList<String>();

	public PerfilUsuarioBean() {
		paises.add("Argentina");
		paises.add("Brasil");
		paises.add("Botsuana");
		paises.add("Australia");
		paises.add("Inglaterra");
		paises.add("Estados Unidos");
		paises.add("Italia");
	}

	public void atualizar() {

		System.out.println("Nome: " + this.nome + "pais: " + this.pais);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atualizado"));

	}

	public List<String> sugerirPaises(String consulta) {

		System.out.println("Consultando" + consulta);

		List<String> paisesSugeridos = new ArrayList<String>();

		for (String paisC : this.paises) {

			if (paisC.toLowerCase().startsWith(consulta.toLowerCase())) {

				paisesSugeridos.add(paisC);

			}

		}

		return paisesSugeridos;
	}

	
	//===================
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<String> getPaises() {
		return paises;
	}

	public void setPaises(List<String> paises) {
		this.paises = paises;
	}

}
