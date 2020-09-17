package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/cozinhas", produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {

	@Autowired
	private CozinhaService service;

	@GetMapping
	public List<Cozinha> listar() {
		return this.service.listar();
	}

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
		Cozinha cozinha = this.service.buscar(id);
		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cozinha> adicionar(@RequestBody Cozinha cozinha) {
		
		Cozinha cozinhaCriada = null;
		ResponseEntity response = null;
		
		try {
			
			cozinhaCriada = this.service.salvar(cozinha);
			response = ResponseEntity.status(HttpStatus.CREATED).body(cozinhaCriada);

		} catch(Exception e) {
			
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			
		}
		
		return response;
	}

	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) throws Exception {

		Cozinha cozinhaAtual = service.buscar(cozinhaId);
		ResponseEntity response = null;

		try {

			if (cozinhaAtual == null) {
				response = ResponseEntity.notFound().build();
			}

			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			this.service.salvar(cozinhaAtual);
			response = ResponseEntity.ok(cozinhaAtual);

		} catch(Exception e){
			response =  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

		return response;

	}

	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {
		
		try {
			
			Cozinha cozinha = service.buscar(cozinhaId);
	
			if (cozinha == null) {
				return ResponseEntity.notFound().build();
			}
	
			service.remover(cozinha);
	
			return ResponseEntity.noContent().build();
		
		} catch(DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
}