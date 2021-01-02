package com.orangetalents.cfilipeandrade.demo.validacao.validadores;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.orangetalents.cfilipeandrade.demo.repository.ClienteRepository;
import com.orangetalents.cfilipeandrade.demo.validacao.anotacoes.UnicoEmail;

import org.springframework.beans.factory.annotation.Autowired;

public class UnicoEmailValidator implements ConstraintValidator <UnicoEmail, String>{

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !clienteRepository.findByEmail(email).isPresent();
    }
    
    
}
