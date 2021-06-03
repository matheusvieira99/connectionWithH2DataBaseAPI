package com.biblioteca.api.bibliotecaApi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@Entity
@Table
public class LivroEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 5, max = 30)
	@Column(name = "titulo")
	private String titulo;
	
	@NotNull
	@Size(min = 3, max = 20)
	@Column(name = "tipo")
	private String tipo;
	
	@NotNull
	@Size(min = 10, max = 40)
	@Column(name = "autor", nullable = false, length = 40)
	private String autor;
	
	@Past
	private LocalDate dataPublicacao;
	
	
	public LivroEntity() {
		super();
	}

	public LivroEntity(Integer id, String titulo, String tipo, String autor, LocalDate dataPublicacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.tipo = tipo;
		this.autor = autor;
		this.dataPublicacao = dataPublicacao;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	

}
