package com.generation.games.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.games.model.Categorias;
import com.generation.games.repository.CategoriasRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriasController {

	@Autowired
	private CategoriasRepository repository;
	
	@GetMapping	
	public ResponseEntity <List<Categorias>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> getById(@PathVariable Long id){
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/categorias/{genero}")
	public ResponseEntity<List<Categorias>> GetByCategorias(@PathVariable String genero){
		return ResponseEntity.ok(repository.findAllByGeneroContainingIgnoreCase(genero));
	}
	
	@PostMapping
	public ResponseEntity<Categorias>post(@Valid @RequestBody Categorias categorias){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categorias));
	}
	
	@PutMapping
	public ResponseEntity<Categorias>put(@RequestBody Categorias categorias){
		return ResponseEntity.ok(repository.save(categorias));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		repository.deleteById(id);
	}
}
