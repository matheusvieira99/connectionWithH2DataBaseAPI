package com.biblioteca.api.bibliotecaApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.api.bibliotecaApi.entity.LivroEntity;
import com.biblioteca.api.bibliotecaApi.exceptions.IdNotFound;
import com.biblioteca.api.bibliotecaApi.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	LivroService service;
	
	@GetMapping
	public ResponseEntity<List<LivroEntity>> getAll(){
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public LivroEntity findById(@PathVariable Integer id) throws IdNotFound {
		return service.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody LivroEntity novoLivro) {
		service.create(novoLivro);
		return new ResponseEntity<String>("Criado com sucesso", HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<LivroEntity> update(@PathVariable Integer id, @RequestBody LivroEntity novoLivro) throws IdNotFound{
		return new ResponseEntity<LivroEntity>(service.update(id, novoLivro), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<LivroEntity> delete(@PathVariable Integer id){
		return new ResponseEntity<LivroEntity>(HttpStatus.GONE);
	}
}
