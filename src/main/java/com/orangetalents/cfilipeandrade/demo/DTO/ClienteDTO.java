package com.orangetalents.cfilipeandrade.demo.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.orangetalents.cfilipeandrade.demo.model.Conta;
import com.orangetalents.cfilipeandrade.demo.validacao.anotacoes.Mais18;
import com.orangetalents.cfilipeandrade.demo.validacao.anotacoes.UnicoCpf;
import com.orangetalents.cfilipeandrade.demo.validacao.anotacoes.UnicoEmail;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = " {campo.nome.obrigatorio}")
    private String nome;

    @CPF(message = "{campo.cpf.invalido}")
    @UnicoCpf(message = "{campo.cpf.repetido}")
    private String cpf;

    @Email(message = "{campo.email.invalido}")
    @UnicoEmail(message = "{campo.email.repetido}")
    private String email;

    @NotNull(message = "{campo.data-nascimento.obrigatorio}")
    @Mais18(message = "{campo.data-nascimento.maioridade}")
    @Past(message = "{campo.data-nascimento.invalida}")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    private Conta conta;
    
}
