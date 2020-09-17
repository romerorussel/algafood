package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	public List<Cozinha> listar() {
		TypedQuery<Cozinha> tq = manager.createQuery("from Cozinha", Cozinha.class);
		return tq.getResultList();
	}

	@Override
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	/**
	 * Este método é utilizado para salvar um objeto já existente/novo na base de dados e registrá-lo no
	 * gerenciador do JPA = EntityManager
	 * @param cozinha
	 */
	@Transactional
	@Override
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {

		Cozinha cozinha = buscar(id);

		if(cozinha == null){
			throw new EmptyResultDataAccessException(1);
		}

		manager.remove(cozinha);
	}

}
