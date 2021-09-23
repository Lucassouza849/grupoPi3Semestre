package br.com.smarttools.oficina.controller;

import br.com.smarttools.oficina.model.Oficina;
import br.com.smarttools.oficina.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oficinas")
public class OficinaController {
    @Autowired
    private OficinaRepository oficinaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String criarOficina(@RequestBody Oficina novaOficina){
        oficinaRepository.save(novaOficina);
        return "oficina criada com sucesso";
    }

    @GetMapping
    public List<Oficina> obterOficinas(){
        return oficinaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oficina> buscar(@PathVariable int id){
        return oficinaRepository.findById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public String deletarOficina(@PathVariable int id){
       oficinaRepository.deleteById(id);
       return "Oficina Deletada com sucesso!";
    }

}
