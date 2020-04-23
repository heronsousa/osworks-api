package com.osworks.osworksapi.controller;

import java.util.Arrays;
import java.util.List;

import com.osworks.osworksapi.domain.model.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setName("Mauro");
        cliente1.setEmail("mauro@email.com");
        cliente1.setPhone("11 9999-2222");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setName("Maria");
        cliente2.setEmail("maria@email.com");
        cliente2.setPhone("21 7777-4444");

        return Arrays.asList(cliente1, cliente2);
    }
}