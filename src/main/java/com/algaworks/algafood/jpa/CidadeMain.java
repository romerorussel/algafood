package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApi2Application;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;

public class CidadeMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
		
		System.out.println("---- Listando Cidades ----");
		for (Cidade cidade : cidadeRepository.listar()) {
			System.out.printf("Nome: %s\n", cidade.getNome());
		}
		
		System.out.println("---- Adicionando uma nova cidade ----");
		
		Estado estadoTeste = new Estado();
		estadoTeste.setId(4L);
		estadoTeste.setNome("Santa Catarina");
		Cidade cidadeTeste = new Cidade();
		cidadeTeste.setNome("Bluemanu");
		cidadeTeste.setEstado(estadoTeste);
		
		cidadeRepository.salvar(cidadeTeste);
		
		System.out.println("---- Buscando uma Cidades ----");
		
		System.out.printf("Cidade: %s\n", cidadeRepository.buscar(3L).getNome());
		
		System.out.println("---- Alterando uma cidade ----");
		
		Cidade cidadeAlterada = cidadeRepository.buscar(2L);
		cidadeAlterada.setNome("Sampa");
		
		cidadeRepository.salvar(cidadeAlterada);
		
		System.out.println("---- Removendo uma Cidade ----");
		
		cidadeRepository.remover(1L);
		
	}

}
