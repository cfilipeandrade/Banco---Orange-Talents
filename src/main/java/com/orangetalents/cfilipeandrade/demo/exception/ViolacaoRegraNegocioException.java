package com.orangetalents.cfilipeandrade.demo.exception;

public class ViolacaoRegraNegocioException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ViolacaoRegraNegocioException(String mensagem) {
        super(mensagem);
        
    }

}