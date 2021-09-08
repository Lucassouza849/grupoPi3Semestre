package br.com.smarttools.financeiro.controller;


import br.com.smarttools.financeiro.model.Entrada;
import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.model.Saida;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/extratos")
public class ExtratoController {
    private List<Extrato> listaExtrato = new ArrayList<>();



    @GetMapping
    public List<Extrato> getExtrato(){
        return listaExtrato;
    }

    @PostMapping("/entradas")
    public String criarEntrada(@RequestBody Entrada novoExtrato) {
           novoExtrato.setData(LocalDateTime.now());
           listaExtrato.add(novoExtrato);
           return "operação criada com sucesso!";
    }

    @PostMapping("/saidas")
    public String criarSaida(@RequestBody Saida novoRegistro) {
        novoRegistro.setData(LocalDateTime.now());
        listaExtrato.add(novoRegistro);
        return "operação criada com sucesso!";
    }

}

