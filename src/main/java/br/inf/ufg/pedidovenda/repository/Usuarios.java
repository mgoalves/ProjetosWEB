package br.inf.ufg.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.inf.ufg.pedidovenda.model.Usuario;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Usuario buscarPorId(long id) {

		return manager.find(Usuario.class, id);
	}

	public List<Usuario> buscarPorNome() {

		// TODO filtrar apenas os vendedores.
		return manager.createQuery("from Usuario", Usuario.class).getResultList();
	}

	public Usuario buscarPorEmail(String email) {
		
		Usuario usuario = null;
		
		try {
			
			usuario = this.manager.createQuery("from Usuario where lower(email) = :email", Usuario.class)
					.setParameter("email", email.toLowerCase()).getSingleResult();
			
		} catch (NoResultException e) {
			
			//Nenhum usuário encontrado com o email informado.
		}
		return usuario;
	}
}
