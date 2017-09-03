package br.inf.ufg.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.inf.ufg.pedidovenda.model.produto.Categoria;

public class Categorias implements Serializable {

	// Injeções
	@Inject
	private EntityManager manager;

	// Variáveis
	private static final long serialVersionUID = 1L;

	/*
	 * @Return lista das categorias raizes do banco.
	 */
	public List<Categoria> buscarCategoriasRaizes() {

		return manager.createQuery("from Categoria where categoriaPai is null",
				Categoria.class).getResultList();
	}

	// Retorna a categoria que foi encontrada a partir do ID solicitado.
	public Categoria buscarPorId(Long id) {

		return manager.find(Categoria.class, id);
	}

	public List<Categoria> subCategoriaDe(Categoria categoriaPai) {

		return manager.createQuery("from Categoria where categoriaPai = :raiz", 
				Categoria.class).setParameter("raiz", categoriaPai).getResultList();
	}
}
