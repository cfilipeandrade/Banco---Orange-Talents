package com.orangetalents.cfilipeandrade.demo.service;

import com.orangetalents.cfilipeandrade.demo.DTO.ClienteDTO;
import com.orangetalents.cfilipeandrade.demo.DTO.RespostaClienteDTO;
import com.orangetalents.cfilipeandrade.demo.model.Cliente;

import org.springframework.data.domain.Page;

public interface ClienteService {
    Page<RespostaClienteDTO> buscarTodosClientes(org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable pageable);

    Cliente atualizarClientePeloId(Long id, ClienteDTO cliente);

    Cliente buscarClienteId(Long id);

    Cliente buscarClienteCPF(String cpf);

    Cliente buscarClienteEmail(String email);

    Page<RespostaClienteDTO> buscarClienteNome(String name, org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable pageable);

    Cliente salvarNovoCliente(ClienteDTO cliente);

    void deletarClienteId(Long id); 
}
