package br.com.smarttools.cliente.controller;

import br.com.smarttools.cliente.model.Cliente;
import br.com.smarttools.cliente.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/clientes")
public class ClienteController {


    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }
}

