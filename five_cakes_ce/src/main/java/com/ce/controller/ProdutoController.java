package com.ce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ce.dao.ProdutoService;
import com.ce.dto.ProdutoDTO;
import com.ce.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private ProdutoService service;
	
	public ProdutoController(ProdutoService service) {
		this.service = service;
	}
	
	
	@PostMapping
	public ResponseEntity insert(@RequestBody Produto entity) {
		
		try {
			
			ProdutoDTO dto = service.insert(entity);
			return ResponseEntity.ok().body(dto);
			
		}catch (Exception e) {
			return ResponseEntity.badRequest().body("Nao Foi POssivel Salvar Produto");
		}
	
	}
	
	@GetMapping
	public ResponseEntity findAll() {
		List<ProdutoDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list); 
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity update(@RequestBody Produto entity) {
		ProdutoDTO dto = service.update(entity);
		return ResponseEntity.ok().body(dto);
	}
	
	
}
