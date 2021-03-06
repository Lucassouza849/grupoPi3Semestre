package br.com.smarttools.oficina.controller;

import br.com.smarttools.cliente.model.Cliente;
import br.com.smarttools.oficina.model.Oficina;
import br.com.smarttools.oficina.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/oficinas")
@CrossOrigin
public class OficinaController {
    @Autowired
    private OficinaRepository oficinaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity criarOficina(@RequestBody Oficina novaOficina) {
        oficinaRepository.save(novaOficina);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity obterOficinas() {
        List<Oficina> oficinas = oficinaRepository.findAll();
        if (oficinas.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(oficinas);
        }
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity getOficinaById(@PathVariable Integer id){
        List<Oficina> oficinas = oficinaRepository.findAll();
        List<Oficina> oficinaPorUsuario = new ArrayList<>();
        if (!oficinas.isEmpty()){
            for (Oficina oficina : oficinas){
                if (oficina.getUsuario() != null && oficina.getUsuario().getId().equals(id)){
                    oficinaPorUsuario.add(oficina);
                }
            }
            return ResponseEntity.status(200).body(oficinaPorUsuario);
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable int id) {
        return ResponseEntity.of(oficinaRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarOficina(@PathVariable int id) {
        if (oficinaRepository.existsById(id)) {
            oficinaRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity atualizarOficina(@PathVariable int id, @RequestBody Oficina oficinaAtualizada) {
        if (oficinaRepository.existsById(id)) {
            oficinaAtualizada.setId(id);
            oficinaRepository.save(oficinaAtualizada);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
