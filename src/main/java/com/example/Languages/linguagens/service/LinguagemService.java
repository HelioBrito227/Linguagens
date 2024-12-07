package com.example.Languages.linguagens.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.Languages.linguagens.dto.LinguagemDto;
import com.example.Languages.linguagens.mapper.LinguagemMapper;
import com.example.Languages.linguagens.model.Linguagem;
import com.example.Languages.linguagens.repositorio.RepositorioLinguagem;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LinguagemService {

	private final RepositorioLinguagem repositorioLinguagem;
    private final LinguagemMapper linguagemMapper;

    @SuppressWarnings({ "serial" })
	public List<LinguagemDto> retornaLinguagens(Pageable pageable, Optional<String> nome, Optional<String> tipo, Optional<String>anoCriacao) {
  
    	System.out.println(nome + " " + tipo + " " + anoCriacao);
        List<LinguagemDto> linguagensDto = new ArrayList<>();
                
       final Page<Linguagem> linguagens = repositorioLinguagem.findAll(new Specification<Linguagem>() {
        	@Override
        	public Predicate toPredicate(Root<Linguagem> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        		List<Predicate> predicates = new ArrayList<>();
        		if(nome.isPresent()) {
        			predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("nome"),"%"+nome.get()+"%")));
        		}
        		if(tipo.isPresent()) {
        			predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("tipo"), tipo.get())));
        		}
        		if(anoCriacao.isPresent()) {
        			predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.<LocalDate>get("dataCriacao"), LocalDate.of(Integer.valueOf(anoCriacao.get()), 1, 1) ));
        			predicates.add(criteriaBuilder.lessThanOrEqualTo(root.<LocalDate>get("dataCriacao"), LocalDate.of(Integer.valueOf(anoCriacao.get()), 12, 31) ));
        		}
        		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        	}
        },pageable);
        
        if(!linguagens.isEmpty() && linguagens.hasContent()) {
        	linguagens.getContent().forEach(ling->{
        		linguagensDto.add(linguagemMapper.toLinguagemDto(ling));
        	});
        }
        
        return linguagensDto;
    }

    public void retornaLinguagem(int sequencial) {

    }
    
    public void salvarLinguagem(LinguagemDto linguagemDto) {
    	Linguagem linguagem = linguagemMapper.toLinguagem(linguagemDto);
    	repositorioLinguagem.save(linguagem);
    }

    public void atualizaLinguagem(int sequencial) {

    }

    public void deletaLinguagem(int sequencial) {

    }

	public List<Integer> buscarAnos() {
		List<Integer> anos = new ArrayList<Integer>();
		List<Linguagem> linguagens = repositorioLinguagem.findAll();
		for(Linguagem lang : linguagens) {
			anos.add(lang.getDataCriacao().getYear());
		}
		return anos;
	}

	public List<String> buscarTipos() {
		List<String> tipos = new ArrayList<String>();
		List<Linguagem> linguagens = repositorioLinguagem.findAll();
		for(Linguagem lang : linguagens) {
			tipos.add(lang.getTipo());
		}
		return tipos;
	}
}
