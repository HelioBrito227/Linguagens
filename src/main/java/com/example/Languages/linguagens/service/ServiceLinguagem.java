package com.example.Languages.linguagens.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Languages.linguagens.dto.LinguagemDto;
import com.example.Languages.linguagens.model.Linguagem;
import com.example.Languages.linguagens.repositorio.RepositorioLinguagem;

@Service
public class ServiceLinguagem {

    @Autowired
    RepositorioLinguagem repositorioLinguagem;

    public List<LinguagemDto> retornaLinguagens(Optional<String> nome, Optional<String> tipo) {
        List<Linguagem> linguagens = new ArrayList<>();
        List<LinguagemDto> linguagensDto = null;

        
        return linguagensDto;
    }

    public void retornaLinguagem(int sequencial) {

    }

    public void atualizaLinguagem(int sequencial) {

    }

    public void deletaLinguagem(int sequencial) {

    }
}
