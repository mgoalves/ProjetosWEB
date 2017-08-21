package br.inf.ufg.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.inf.ufg.pedidovenda.model.Usuario;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Usuario buscarPorId(long id) {

		return manager.find(Usuario.class, id);
	}

	public List<Usuario> buscarPorNome() {

		//TODO filtrar apenas os vendedores.
		return manager.createQuery("from Usuario", Usuario.class).getResultList();
	}
}
