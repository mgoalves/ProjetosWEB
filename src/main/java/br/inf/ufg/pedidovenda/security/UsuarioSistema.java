package br.inf.ufg.pedidovenda.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.inf.ufg.pedidovenda.model.Usuario;

public class UsuarioSistema extends User{

	private static final long serialVersionUID = 1L;

	//Usuários
	private Usuario usuario;
	
	public UsuarioSistema(Usuario usuario, 
			Collection<? extends GrantedAuthority> authorities) {
		
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	
	//Getters and Setters
	public Usuario getUsuario() {
		return usuario;
	}
}
