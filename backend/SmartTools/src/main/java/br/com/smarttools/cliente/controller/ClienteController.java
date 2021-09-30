package br.com.smarttools.cliente.controller;

import br.com.smarttools.cliente.model.Cliente;
import br.com.smarttools.cliente.repository.ClienteRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Integer id){
        return clienteRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Cliente> createClient(@RequestBody Cliente newCliente){
       boolean emailEmUso = clienteRepository.findByEmail(newCliente.getEmail())
               .stream()
               .anyMatch(clienteExistente -> !clienteExistente.equals(newCliente));

         if (emailEmUso){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         }
         clienteRepository.save(newCliente);
         return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Integer clienteId, @RequestBody Cliente updateCliente){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        updateCliente.setId(clienteId);
        clienteRepository.save(updateCliente);
        return ResponseEntity.ok(updateCliente);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteClient(@PathVariable Integer id){
        if (!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}

