package com.orangetalents.cfilipeandrade.demo.model;

import java.time.LocalDate;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 150, nullable = false)
    private String nome;

    @CPF
    @Column(nullable = false)
    private String cpf;

    @Email
    @Column(nullable = false)
    private String email;

    @Past
    @NotNull
    private LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;
    
    @Deprecated
    public Cliente() {

    }

    public Cliente(@NotBlank String nome,
                   @NotBlank @CPF String cpf,
                   @NotBlank @Email String email,
                   @NotNull @Past LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    
}


