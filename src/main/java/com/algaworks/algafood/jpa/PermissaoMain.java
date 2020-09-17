package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApi2Application;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

public class PermissaoMain {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
		
		System.out.println("---- Exibindo permissões -----");
		
		for(Permissao Permissao : permissaoRepository.listar()) {
			System.out.printf("Permissão: %s\n", Permissao.getDescricao());
		}
		System.out.println("---- Buscando Permissões -----");
		
		System.out.printf("Permissão encontrada: %s\n", permissaoRepository.buscar(1L));

		System.out.println("---- Adicionando Permissão -----");
		
		Permissao PermissaoNova = new Permissao();
		PermissaoNova.setId(4L);
		PermissaoNova.setNome("VENDAS");
		PermissaoNova.setDescricao("Permite realizar vendas");
		
		permissaoRepository.salvar(PermissaoNova);
		
		System.out.printf("Permissão: %s\n", permissaoRepository.buscar(4L));
		
		System.out.println("---- Alterando Permissão -----");
		
		Permissao PermissaoAlterada = permissaoRepository.buscar(2L);
		PermissaoAlterada.setDescricao("Teste");
		
		permissaoRepository.salvar(PermissaoAlterada);
		
		System.out.printf("Permissão alterada: %s\n", permissaoRepository.buscar(2L));
		
		System.out.println("---- Removendo Permissão -----");
		
		permissaoRepository.remover(1L);
	}
}
