package com.example.Languages.linguagens.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.Languages.linguagens.model.Linguagem;

public interface RepositorioLinguagem extends JpaRepository<Linguagem, Integer>, JpaSpecificationExecutor<Linguagem> {

	Page<Linguagem> findAll(Specification<Linguagem> spec, Pageable page);
}
