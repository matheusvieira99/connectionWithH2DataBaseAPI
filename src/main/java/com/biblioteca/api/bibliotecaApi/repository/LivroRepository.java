package com.biblioteca.api.bibliotecaApi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.api.bibliotecaApi.entity.LivroEntity;

public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {

}
