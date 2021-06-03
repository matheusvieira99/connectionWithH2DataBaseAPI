package com.biblioteca.api.bibliotecaApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.api.bibliotecaApi.entity.LivroEntity;
import com.biblioteca.api.bibliotecaApi.exceptions.IdNotFound;
import com.biblioteca.api.bibliotecaApi.repository.LivroRepository;

@Service
public class LivroService {
	List<LivroEntity> livros = new ArrayList<LivroEntity> ();
	
	@Autowired
	LivroRepository repository;
	
	public List<LivroEntity> getAll() {
		return repository.findAll();
	}
	
	public LivroEntity findById(Integer id) throws IdNotFound {
		Optional<LivroEntity> achado = repository.findById(id);
		if(achado.isEmpty()) {
			throw new IdNotFound("Id não econtrado");
		}
		return achado.get();
	}
	
	public void create(LivroEntity novo) {
		livros.add(novo);
		repository.save(novo);
	}
	
	public LivroEntity update (Integer id, LivroEntity livroUpdate) throws IdNotFound {
		LivroEntity livro = findById(id);
		if(((List<LivroEntity>) livro).isEmpty()) {
			throw new IdNotFound ("Id não encontrado.");
		}
		if(livroUpdate.getTitulo() != null) {
			livro.setTitulo(livroUpdate.getTitulo());
		}
		if(livroUpdate.getAutor() != null) {
			livro.setAutor(livroUpdate.getAutor());
		}
		if(livroUpdate.getTipo() != null) {
			livro.setTipo(livroUpdate.getTipo());
		}
		if(livroUpdate.getDataPublicacao() != null) {
			livro.setDataPublicacao(livroUpdate.getDataPublicacao());
		}
		repository.save(livro);
		return livro;
	}
	
	public String delete(Integer id) throws IdNotFound {
		LivroEntity livro = findById(id);
		repository.delete(livro);
		return "Deletei o livro do id: " + id;
	}
	
	

}
