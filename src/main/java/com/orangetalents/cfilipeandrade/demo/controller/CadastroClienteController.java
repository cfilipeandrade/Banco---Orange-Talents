package com.orangetalents.cfilipeandrade.demo.controller;

import java.net.URI;

import javax.validation.Valid;

import com.orangetalents.cfilipeandrade.demo.DTO.ClienteDTO;
import com.orangetalents.cfilipeandrade.demo.mapper.ClienteMapper;
import com.orangetalents.cfilipeandrade.demo.model.Cliente;
import com.orangetalents.cfilipeandrade.demo.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value = "Cadastro de cliente", description = "Cliente->Cpf - Aceite", tags = {"Cadastro de Clientes"})
@RestController
@RequestMapping("cadastro")
public class CadastroClienteController {

    @Autowired
	public
    ClienteService clienteService;

    @Autowired
    ClienteMapper clienteMapper;
    
    @PostMapping("/cliente")
    @ApiOperation(value = "Salva dados do Cliente")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Não foi possível criar o Cliente"),
            @ApiResponse(code = 201, message = "Cliente criado com sucesso")})
    public ResponseEntity salvarCliente(@RequestBody @Valid ClienteDTO client) {
        Cliente clienteSalvo = clienteService.salvarNovoCliente(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteMapper.converterParaRespostaClienteDTO(clienteSalvo));
    }

    
}
