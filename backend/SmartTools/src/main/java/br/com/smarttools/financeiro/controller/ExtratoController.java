package br.com.smarttools.financeiro.controller;



import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.repository.Faturavel;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String postExtrato(@RequestBody Extrato novoExtrato) {
        novoExtrato.setDataRegistro(LocalDateTime.now());
        repository.save(novoExtrato);
        return "Extrato Cadastrado";
    }

    @GetMapping
    public List<Extrato> getExtrato() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Extrato getExtrato(@PathVariable int id) {
        return repository.findById(id).get();
    }


    @DeleteMapping("/{id}")
    public String deleteExtrato(@PathVariable int id) {
        repository.deleteById(id);
        return "Extrato Excluído";

    }


}

