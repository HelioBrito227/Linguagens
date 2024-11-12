package com.example.Languages.linguagens.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Languages.linguagens.model.Linguagem;

@Repository
public interface RepositorioLinguagem extends JpaRepository<Linguagem, Integer>, JpaSpecificationExecutor<Linguagem> {

	Page<Linguagem> findAll(Specification<Linguagem> spec, Pageable page);
	
	@Query("""
			SELECT l
			FROM Linguagem l
			WHERE YEAR(l.dataCriacao) = :anoCriacao
			""")
	List<Linguagem>getLinguagensPorAno(Optional<String> anoCriacao);
}
