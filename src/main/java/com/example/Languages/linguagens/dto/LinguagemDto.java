package com.example.Languages.linguagens.dto;

import java.time.LocalDate;

public record LinguagemDto(
		String nome,
		String tipo,
		LocalDate dataCriacao,
		String descricao
		) {
}