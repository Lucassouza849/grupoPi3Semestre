package br.com.smarttools.financeiro.controller;



import br.com.smarttools.financeiro.model.Despesas;
import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.model.Receita;
import br.com.smarttools.financeiro.model.Saldo;
import br.com.smarttools.financeiro.repository.FaturavelRepository;
import br.com.smarttools.financeiro.repository.ExtratoRepository;
import br.com.smarttools.financeiro.repository.SaldoRepository;
import br.com.smarttools.oficina.model.Oficina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/extratos")
public class ExtratoController {

    @Autowired
    private FaturavelRepository faturavelRepository;
    private SaldoRepository saldoRepository;



    @PostMapping("/receitas")
    public ResponseEntity adicionarReceita(@RequestBody Receita novaReceita){
            novaReceita.setDataRegistro(LocalDateTime.now());
            faturavelRepository.save(novaReceita);
            return ResponseEntity.status(201).build();
    }

    @PostMapping("/despesas")
    public ResponseEntity adicionarDespesa(@RequestBody Despesas novaDespesa){
            novaDespesa.setDataRegistro(LocalDateTime.now());
            faturavelRepository.save(novaDespesa);
            return ResponseEntity.status(201).build();
    }


    @GetMapping
    public ResponseEntity todosEntradas(){
        List<Extrato> extrato = faturavelRepository.findAll();
        if (extrato.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(extrato);
        }
    }



// List<Extrato>
//@GetMapping
//public ResponseEntity getExtrato() {
//
//    List<Extrato> extrato = repository.findAll();
//    Iterator<Extrato> it = extrato.iterator();
//
//    Extrato ext = new Extrato();
//
//    if (extrato.isEmpty()) {
//        return ResponseEntity.status(204).build();
//    } else {
//        return ResponseEntity.status(200).body(extrato);
//
//    }
//}
//
//    @GetMapping("/ultimoExtrato")
//    public ResponseEntity getUltimoExtrato() {
//
//        List<Extrato> extrato = repository.findAll();
//        Iterator<Extrato> it = extrato.iterator();
//
//        Extrato ext = new Extrato();
//
//        if (extrato.isEmpty()) {
//            return ResponseEntity.status(204).build();
//        } else {
//            ext = it.next();
//            return ResponseEntity.status(200).body(ext);
//
//        }
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity getExtrato(@PathVariable int id) {
//        return ResponseEntity.of(repository.findById(id));
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteExtrato(@PathVariable int id)  {
//        if (repository.existsById(id)) {
//            repository.deleteById(id);
//            return ResponseEntity.status(200).build();
//        } else {
//            return ResponseEntity.status(404).build();
//        }
//    }




    }




