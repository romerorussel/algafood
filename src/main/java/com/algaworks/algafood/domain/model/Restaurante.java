package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
public class Restaurante {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(name = "taxa_frete")
	private BigDecimal taxaRestaurante;
	
	/* Caso eu queira especificar manualmente o nome da coluna gerada
	 * é só utilizar a anotação @JoinColumn passano o name como parâmetro
	 * caso contrário o hibernate irá criar de acordo com um padrão
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	private Cozinha cozinha;
	
}
