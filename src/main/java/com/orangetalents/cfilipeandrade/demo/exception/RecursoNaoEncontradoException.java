package com.orangetalents.cfilipeandrade.demo.exception;

import java.util.List;

import lombok.Getter;

public class RecursoNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Getter
    List<String> erros;

    public RecursoNaoEncontradoException(List<String> listErros){
        this.erros = listErros;
    }

    public RecursoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}