package com.orangetalents.cfilipeandrade.demo.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.orangetalents.cfilipeandrade.demo.model.Conta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String cpf;

    private String email;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Conta conta;
    
}
