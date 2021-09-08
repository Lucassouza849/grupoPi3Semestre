package br.com.smarttools.cliente.controller;

import br.com.smarttools.cliente.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private List<Cliente> listaClientes;

    public ClienteController() {
        this.listaClientes = new ArrayList<>();
    }

    @GetMapping
    public List<Cliente> getClientes(){
        listaClientes.stream()
                .sorted(Comparator.comparing(Cliente :: getId))
                .collect(Collectors.toList());
        return listaClientes;
    }

    @PostMapping
    public String cadastrarClientes(@RequestBody Cliente novoCliente){
        novoCliente.setId(ThreadLocalRandom.current().nextInt(0, 1000));
        listaClientes.add(novoCliente);
        return "cliente cadastrado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Integer id){
        listaClientes.remove(listaClientes.stream()
                .filter(listaClientes -> listaClientes.getId().equals(id))
                .findFirst().get());
        return "Cliente excluido do sistema com sucesso!";
    }

}
