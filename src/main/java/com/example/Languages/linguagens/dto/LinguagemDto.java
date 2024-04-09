package com.example.Languages.linguagens.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.Languages.linguagens.model.Linguagem;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LinguagemDto {
    
    String nome;
    String tipo;
    LocalDate dataCriacao;
    String descricao;

    public LinguagemDto(Linguagem linguagem){
        super();
        this.nome = linguagem.getNome();
        this.tipo = linguagem.getTipo();
        this.dataCriacao = linguagem.getDataCriacao();
        this.descricao = linguagem.getDescricao();
    }

    public static List<LinguagemDto> listarEmDto(List<Linguagem> lista){
        List<LinguagemDto> dtos = new ArrayList<>();
        for(Linguagem ling:lista){
            dtos.add(new LinguagemDto(ling));
        }
        return dtos;
    }

}
