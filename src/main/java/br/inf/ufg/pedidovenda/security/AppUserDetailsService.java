package br.inf.ufg.pedidovenda.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.inf.ufg.pedidovenda.model.Usuario;
import br.inf.ufg.pedidovenda.model.produto.Grupo;
import br.inf.ufg.pedidovenda.repository.Usuarios;
import br.inf.ufg.pedidovenda.util.cdi.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Usuarios usuarios = CDIServiceLocator.getBean(Usuarios.class);
		Usuario usuario = usuarios.buscarPorEmail(email);
		UsuarioSistema user = null;

		if (usuario != null) {

			user = new UsuarioSistema(usuario, getGrupos(usuario));

		}

		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Grupo grupo : usuario.getGrupos()) {
			
			authorities.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
		}
		
		return authorities;
	}
}
