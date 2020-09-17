package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApi2Application;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		for(Cozinha cozinha : cozinhaRepository.listar()) {
			System.out.println("Resultado: " + cozinha.getNome());
		}
		
		Cozinha cozinhaTeste = new Cozinha();
		cozinhaTeste.setNome("teste");
		cozinhaTeste.setId(1L);
		
		cozinhaRepository.salvar(cozinhaTeste);
		
		
		
	}

}
