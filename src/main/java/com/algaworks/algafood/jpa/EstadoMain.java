package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApi2Application;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class EstadoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);
		
		System.out.println("---- Exibindo Estados -----");
		
		for(Estado estado : estadoRepository.listar()) {
			System.out.printf("Estado: %s\n", estado.getNome());
		}
		System.out.println("---- Buscando Estado -----");
		
		System.out.printf("Estado encontrado: %s\n", estadoRepository.buscar(1L));

		System.out.println("---- Adicionando Estado -----");
		
		Estado estadoNovo = new Estado();
		estadoNovo.setNome("Brasília");
		
		estadoRepository.salvar(estadoNovo);
		
		System.out.printf("Estado novo: %s\n", estadoRepository.buscar(4L));
		
		System.out.println("---- Alterando Estado -----");
		
		Estado estadoAlterado = estadoRepository.buscar(2L);
		estadoAlterado.setNome("Rio de Janeiro");
		
		estadoRepository.salvar(estadoAlterado);
		
		System.out.printf("Estado alterado: %s\n", estadoRepository.buscar(2L));
		
		/*
		System.out.println("---- Removendo Estados -----");
		
		estadoRepository.remover(3L);
		*/
	}

}
