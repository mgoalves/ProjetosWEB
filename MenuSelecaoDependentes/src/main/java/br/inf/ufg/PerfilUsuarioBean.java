package br.inf.ufg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> estados = new ArrayList<String>();
	private List<String> cidades = new ArrayList<String>();
	
	public PerfilUsuarioBean() {
		
		estados.add("MG");
		estados.add("GO");
		estados.add("RJ");
	}
	public void carregarCidades() {
		cidades.clear();
		
		if("MG".equals(estado)) {
			
			cidades.add("Belo Horizonte");
			cidades.add("Confins");
			cidades.add("Contagem");
			cidades.add("Nova Lima");
			
		} else if ("GO".equals(estado)) {
			
			cidades.add("Goiânia");
			cidades.add("Anapolis");
			cidades.add("Aparecida de Goiânia");
			
		} else if ("RJ".equals(estado)) {
			
			cidades.add("Goiânia");
			cidades.add("Anapolis");
		}
		
	}
	
	private String nome;
	private String estado;
	private String cidade;

	public void atualizar() {

		System.out.println("Nome: " + this.nome + "\nEstado: " + this.estado + "\nCidade: " + this.cidade);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil Atualizado"));

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<String> getEstados() {
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

	public List<String> getCidades() {
		return cidades;
	}

	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}

}
