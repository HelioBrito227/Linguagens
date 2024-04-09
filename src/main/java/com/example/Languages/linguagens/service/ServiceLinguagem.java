package com.example.Languages.linguagens.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.Languages.linguagens.dto.LinguagemDto;
import com.example.Languages.linguagens.model.Linguagem;
import com.example.Languages.linguagens.repositorio.RepositorioLinguagem;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class ServiceLinguagem {

    @Autowired
    RepositorioLinguagem repositorioLinguagem;

    @SuppressWarnings("serial")
	public List<LinguagemDto> retornaLinguagens(Pageable pageable, Optional<String> nome, Optional<String> tipo) {
  
        List<LinguagemDto> linguagensDto = new ArrayList<>();
        Page<Linguagem> linguagens = null;
        
        linguagens = repositorioLinguagem.findAll(new Specification<Linguagem>() {
        	@Override
        	public Predicate toPredicate(Root<Linguagem> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        		List<Predicate> predicates = new ArrayList<>();
        		if(nome.isPresent()) {
        			predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("nome"),"%"+nome.get()+"%")));
        		}
        		if(tipo.isPresent()) {
        			predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("tipo"),"%"+tipo.get()+"%")));
        		}
        		
        		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        	}
        },pageable);
        
        if(!linguagens.isEmpty() && linguagens.hasContent()) {
        	linguagens.getContent().forEach(ling->{
        		linguagensDto.add(LinguagemDto.transformaEmDto(ling));
        	});
        }
        
        return linguagensDto;
    }

    public void retornaLinguagem(int sequencial) {

    }

    public void atualizaLinguagem(int sequencial) {

    }

    public void deletaLinguagem(int sequencial) {

    }
}
