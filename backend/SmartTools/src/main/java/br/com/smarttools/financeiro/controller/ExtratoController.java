package br.com.smarttools.financeiro.controller;



import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.repository.Faturavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/extratos")
public class ExtratoController {

    @Autowired
    private Faturavel repository;


    @PostMapping
    public ResponseEntity postExtrato(@RequestBody Extrato novoExtrato) {
        novoExtrato.setDataRegistro(LocalDateTime.now());
        repository.save(novoExtrato);
         return ResponseEntity.status(201).build();
    }
// List<Extrato>
    @GetMapping
    public ResponseEntity getExtrato() {
        List<Extrato> extrato = repository.findAll();
        if (extrato.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else  {
            return ResponseEntity.status(200).body(extrato);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity getExtrato(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteExtrato(@PathVariable int id)  {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }


    }




