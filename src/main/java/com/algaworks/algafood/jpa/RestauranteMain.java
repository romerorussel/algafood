package com.algaworks.algafood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApi2Application;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class RestauranteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		for(Restaurante restaurante : restauranteRepository.listar()) {
			System.out.println("Resultado: " + restaurante.getNome());
		}
		
		//Alterando um registro já existente.
		
		Restaurante restauranteTeste = restauranteRepository.buscar(1L);
		restauranteTeste.setNome("Restaurante alterado");
		
		restauranteRepository.salvar(restauranteTeste);
		
		//Persistindo uma novo registro
		
		Cozinha cozinha = new Cozinha();
		cozinha.setNome("Nordestina");
		
		Restaurante restauranteNovo = new Restaurante();
		restauranteNovo.setNome("Pernambucano");
		restauranteNovo.setTaxaRestaurante(new BigDecimal(1.5));
		restauranteNovo.setCozinha(cozinha);
		
		restauranteRepository.salvar(restauranteNovo);
		
		System.out.println("Buscando restaurante alterado: " + restauranteRepository.buscar(1L).getNome());
		
		System.out.println("============= EXCLUINDO RESTAURANTE =============");
		
		restauranteRepository.remover(3L);
		
		for(Restaurante restaurante : restauranteRepository.listar()) {
			System.out.printf("%s - %f - %s\n",
					restaurante.getNome(),
					restaurante.getTaxaRestaurante(),
					restaurante.getCozinha().getNome());
		}

	}

}
