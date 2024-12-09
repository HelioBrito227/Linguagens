package com.example.Languages.linguagens.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Languages.linguagens.dto.LinguagemDto;
import com.example.Languages.linguagens.model.Linguagem;

@Service
public class LinguagemMapper {
	
    public LinguagemDto toLinguagemDto(Linguagem linguagem){
    	return new LinguagemDto(
    			linguagem.getSequencial(),
    			linguagem.getNome(),
    			linguagem.getTipo(),
    			linguagem.getDataCriacao(),
    			linguagem.getDescricao()
    			);
    }

    public List<LinguagemDto> listarEmDto(List<Linguagem> lista){
        List<LinguagemDto> dtos = new ArrayList<>();
        for(Linguagem ling:lista){
            dtos.add(toLinguagemDto(ling));
        }
        return dtos;
    }
    
    public Linguagem toLinguagem(LinguagemDto linguagemDto) {
    	Linguagem linguagem = new Linguagem();
    	linguagem.setNome(linguagemDto.nome());
    	linguagem.setDescricao(linguagemDto.descricao());
    	linguagem.setDataCriacao(linguagemDto.dataCriacao());
    	linguagem.setTipo(linguagemDto.tipo());
    	
    	return linguagem;
    }
}
