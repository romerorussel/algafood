package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApi2Application;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class FormaPagamentoMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		System.out.println("---- Exibindo formas de pagamento -----");
		
		for(FormaPagamento formaPagamento : formaPagamentoRepository.listar()) {
			System.out.printf("Forma de pagamento: %s\n", formaPagamento.getDescricao());
		}
		System.out.println("---- Buscando formas de pagamento -----");
		
		System.out.printf("Forma de pagamento encontrada: %s\n", formaPagamentoRepository.buscar(1L));

		System.out.println("---- Adicionando forma de pagamento -----");
		
		FormaPagamento formaPagamentoNova = new FormaPagamento();
		formaPagamentoNova.setId(4L);
		formaPagamentoNova.setDescricao("Cheque");
		
		formaPagamentoRepository.salvar(formaPagamentoNova);
		
		System.out.printf("Forma de pagamento nova: %s\n", formaPagamentoRepository.buscar(4L));
		
		System.out.println("---- Alterando Estado -----");
		
		FormaPagamento formaPagamentoAlterada = formaPagamentoRepository.buscar(2L);
		formaPagamentoAlterada.setDescricao("Teste");
		
		formaPagamentoRepository.salvar(formaPagamentoAlterada);
		
		System.out.printf("Forma de pagamento alterada: %s\n", formaPagamentoRepository.buscar(2L));
		
		System.out.println("---- Removendo forma de pagamento -----");
		
		formaPagamentoRepository.remover(1L);
		

	}

}
