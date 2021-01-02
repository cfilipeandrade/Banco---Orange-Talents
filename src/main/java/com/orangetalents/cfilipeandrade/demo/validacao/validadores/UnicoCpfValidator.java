package com.orangetalents.cfilipeandrade.demo.validacao.validadores;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.orangetalents.cfilipeandrade.demo.repository.ClienteRepository;
import com.orangetalents.cfilipeandrade.demo.validacao.anotacoes.UnicoCpf;

import org.springframework.beans.factory.annotation.Autowired;

public class UnicoCpfValidator implements ConstraintValidator<UnicoCpf, String> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        return !clienteRepository.findByCpf(cpf).isPresent();
    }

    public ClienteRepository getClienteRepository() {
        return clienteRepository;
    }

    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public UnicoCpfValidator(ClienteRepository clienteRepository) {
        this.setClienteRepository(clienteRepository);
    }   
}
