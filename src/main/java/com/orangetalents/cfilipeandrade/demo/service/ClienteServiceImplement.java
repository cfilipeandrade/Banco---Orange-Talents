package com.orangetalents.cfilipeandrade.demo.service;

import java.util.List;
import java.util.Optional;

import com.orangetalents.cfilipeandrade.demo.DTO.ClienteDTO;
import com.orangetalents.cfilipeandrade.demo.DTO.RespostaClienteDTO;
import com.orangetalents.cfilipeandrade.demo.mapper.ClienteMapper;
import com.orangetalents.cfilipeandrade.demo.model.Cliente;
import com.orangetalents.cfilipeandrade.demo.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImplement implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteMapper clienteMapper;

    private Long id;

    private ClienteDTO cliente;

    private Pageable pageable;

    private Cliente converterParaCliente(ClienteDTO cliente) {
        return clienteMapper.converterParaCliente(cliente);
    }

    private List<RespostaClienteDTO> converterParaListaRespostaClienteDTO(List<Cliente> listaClientes) {
        return clienteMapper.converterParaListaRespostaClienteDTO(listaClientes);
    }

    private Page<RespostaClienteDTO> converterParaPageRespostaClienteDTO(Page<Cliente> paginaClientes,
            Pageable pageable {
        this.pageable = pageable;
		List<RespostaClienteDTO> dtos = converterParaListaRespostaClienteDTO(paginaClientes.getContent());
        return new PageImpl<>(dtos, pageable, paginaClientes.getTotalElements());
    }

    @Override
    public Page<RespostaClienteDTO> buscarTodosClientes(Pageable pageable) {
        Page<Cliente> paginaClientes = clienteRepository.findAll(pageable);
        return converterParaPageRespostaClienteDTO(paginaClientes, pageable);
    }

    @Override
    public Page<RespostaClienteDTO> buscarClienteNome(String nome, Pageable pageable) {
        Page<Cliente> paginaClientes = clienteRepository.findAllByNome(nome, pageable);
        return converterParaPageRespostaClienteDTO(paginaClientes, pageable);
    }

    @Override
    public Cliente buscarClienteId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElseThrow(() -> new RecursoNaoEncontrado("Não existe cliente com o ID: " + id));
    }

    @Override
    public Cliente buscarClienteCPF(String cpf) {
        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpf);
        return clienteOptional
                .orElseThrow(() -> new RecursoNaoEncontrado("Não existe cliente cadastrado com o CPF: " + cpf));
    }

    @Override
    public Cliente buscarClienteEmail(String email) {
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(email);
        return clienteOptional
                .orElseThrow(() -> new RecursoNaoEncontrado("Não existe cliente cadastrado com o E-mail: " + email));
    }

    @Override
    public Cliente salvarNovoCliente(ClienteDTO clienteDTO) {
        Cliente cliente = converterParaCliente(clienteDTO);
        return clienteRepository.save(cliente);
    }
}
