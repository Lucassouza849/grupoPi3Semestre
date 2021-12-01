package br.com.smarttools.cliente.controller;

import br.com.smarttools.cliente.model.Cliente;
import br.com.smarttools.cliente.repository.ClienteRepository;
import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.listaObj.FilaObj;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/clientes")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    FilaObj<Cliente> fila = new FilaObj<>(1000);

//    @GetMapping
//    public List<Cliente> getClientes() {
//        return clienteRepository.findAll();
//    }

//    @GetMapping("/{id}")
//    public Cliente getClienteById(@PathVariable Integer id){
//        return clienteRepository.findById(id).get();
//    }

    @GetMapping("/todos/{id}")
    public ResponseEntity getClienteById(@PathVariable Integer id){
        List<Cliente> clientes = clienteRepository.findAll();
        List<Cliente> clientePorUsuario = new ArrayList<>();
        if (!clientes.isEmpty()){
            for (Cliente cliente : clientes){
                if (cliente.getUsuario() != null && cliente.getUsuario().getId().equals(id)){
                    clientePorUsuario.add(cliente);
                }
            }
            return ResponseEntity.status(200).body(clientePorUsuario);
        }
        return ResponseEntity.status(204).build();
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void insereBanco(){
        if(fila.isEmpty()){
            System.out.println("fila vazia");
        }else{
            while (!fila.isEmpty()) {
                System.out.println("esvaziando fila");
                clienteRepository.save(fila.poll());
            }
        }

    }


    @PostMapping
    public ResponseEntity<Cliente> createClient(@RequestBody Cliente newCliente){
       boolean emailEmUso = clienteRepository.findByEmail(newCliente.getEmail())
               .stream()
               .anyMatch(clienteExistente -> !clienteExistente.equals(newCliente));

         if (emailEmUso){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         }
         fila.insert(newCliente);
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

    //filtro nome
    @GetMapping("por-nome/{nome}")
    public  List<Cliente> getClientePorNome(@PathVariable String nome){
        return clienteRepository.findByNome(nome);
    }

    //filtro telefone
    @GetMapping("por-telefone/{telefone}")
    public List<Cliente> getClientePorTelefone(@PathVariable String telefone){
        return  clienteRepository.findByTelefone(telefone);
    }

}

