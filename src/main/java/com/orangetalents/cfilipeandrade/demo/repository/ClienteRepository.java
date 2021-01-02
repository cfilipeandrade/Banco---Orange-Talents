package com.orangetalents.cfilipeandrade.demo.repository;

import java.util.Optional;

import com.orangetalents.cfilipeandrade.demo.model.Cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Page<Cliente> findAllByNome(String nome, Pageable pageable);

    Optional<Cliente> findByCpf(String cpf);

    Optional<Cliente> findByEmail(String email);
    
    
}
