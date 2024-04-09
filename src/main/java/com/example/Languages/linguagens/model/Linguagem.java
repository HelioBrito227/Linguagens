package com.example.Languages.linguagens.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "linguagem")
public class Linguagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sequencial")
    int sequencial;

    @Column(name = "nome")
    String nome;

    @Column(name = "tipo")
    String tipo;

    @Column(name = "data_criacao")
    LocalDate dataCriacao;

    @Column(name = "descricao")
    String descricao;
}
