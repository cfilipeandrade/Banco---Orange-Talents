package com.orangetalents.cfilipeandrade.demo.mapper;

import java.util.List;

import javax.persistence.MappedSuperclass;

import com.orangetalents.cfilipeandrade.demo.DTO.ClienteDTO;
import com.orangetalents.cfilipeandrade.demo.DTO.RespostaClienteDTO;
import com.orangetalents.cfilipeandrade.demo.model.Cliente;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class ClienteMapper {

    public Cliente converterParaClienteDTO(ClienteDTO clienteDTO);

    public RespostaClienteDTO converterParaRespostaClienteDTO(Cliente cliente);

    public List<RespostaClienteDTO> converterParaListaRespostaClienteDTO(List<Cliente> listaCliente);

    public List<Cliente> converterParaListaCliente(List<ClienteDTO> listaClienteDTO);
    
}
