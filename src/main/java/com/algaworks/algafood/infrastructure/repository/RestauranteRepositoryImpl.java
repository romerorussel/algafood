package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Restaurante> listar() {
		TypedQuery<Restaurante> tq = entityManager.createQuery("from Restaurante", Restaurante.class);
		return tq.getResultList();
	}

	@Override
	public Restaurante buscar(Long id) {
		return entityManager.find(Restaurante.class, id);
	}
	
	/**
	 * Este método é utilizado para salvar um objeto já existente/novo na base de dados e registrá-lo no
	 * gerenciador do JPA = EntityManager
	 * @param restaurante
	 */
	@Transactional
	@Override
	public Restaurante salvar(Restaurante restaurante) {
		return entityManager.merge(restaurante);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		entityManager.remove(buscar(id));
	}

}
