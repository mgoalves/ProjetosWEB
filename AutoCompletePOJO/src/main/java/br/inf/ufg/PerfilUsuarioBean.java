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
	
	public static final List<Pais> PAISES =  new ArrayList<Pais>();
	
	static{
		PAISES.add(new Pais( 1, "Alemanha"));
		PAISES.add(new Pais( 2, "Brasil"));
		PAISES.add(new Pais( 3, "Inglaterra"));
		PAISES.add(new Pais( 4, "Italia"));
		PAISES.add(new Pais( 5, "Canada"));
	}
	
	
	private String nome;
	private Pais pais;
	
	public void atualizar () {
		
		System.out.println("Nome: " + this.nome);
		System.out.println("Pais: " + this.pais.getNome() + "Cod: " + this.pais.getCodigo());
		
		if (this.pais == null) {
			
			adicionarMensagem("Sem país");
			
		} else {
			
			adicionarMensagem("Pais: " + this.pais.getNome() + "Cod: " + this.pais.getCodigo());
		}
	}
	
	public void adicionarMensagem(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
	
	
	
	public List<Pais> sugerirPaises(String consulta){
		List<Pais> paisesSugeridos =  new ArrayList<Pais>();
		
		for (Pais pais : PAISES) {
			
			if(pais.getNome().toLowerCase().startsWith(consulta.toLowerCase())) {
				
				paisesSugeridos.add(pais);
			}
		}
		return paisesSugeridos;
	}

	
	//============================
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	

}