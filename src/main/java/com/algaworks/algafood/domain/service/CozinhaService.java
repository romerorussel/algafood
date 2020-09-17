package com.algaworks.algafood.domain.service;

import static java.util.Calendar.DAY_OF_WEEK;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CozinhaService {

	@Autowired
	private CozinhaRepository repository;


	public List<Cozinha> listar(){
		return repository.listar();
	}
	
	public Cozinha buscar(Long id) {
		return repository.buscar(id);
	}
	
	public Cozinha salvar(Cozinha cozinha) throws Exception {
		
		TimeZone timeZone = TimeZone.getDefault();
		GregorianCalendar calendar = new GregorianCalendar(timeZone);
		
		if(calendar.get(DAY_OF_WEEK) == 1 || calendar.get(DAY_OF_WEEK) == 7) {
			throw new Exception("Não é possível adicionar cozinha em dias da semana.");
		}
		return repository.salvar(cozinha);
	}
	
	public void remover(Long id) {
		repository.remover(id);
	}
	
}
