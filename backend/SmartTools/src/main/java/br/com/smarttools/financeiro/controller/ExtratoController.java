package br.com.smarttools.financeiro.controller;



import br.com.smarttools.financeiro.model.Despesa;
import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.model.Receita;
import br.com.smarttools.financeiro.repository.FaturavelRepository;
import br.com.smarttools.financeiro.repository.SaldoRepository;
import br.com.smarttools.gerararquivo.Gravar;

import br.com.smarttools.listaObj.ListaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Iterator;
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
    public ResponseEntity adicionarDespesa(@RequestBody Despesa novaDespesa){
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

    @GetMapping("/csv")
    public ResponseEntity getCsv(){
        Gravar g = new Gravar();
        ListaObj<Extrato> listaObj = new ListaObj<>((int) faturavelRepository.count());
        ListaObj<Receita> listaReceitas= new ListaObj<>((int) faturavelRepository.count());
        ListaObj<Despesa> listaDespesas= new ListaObj<>((int) faturavelRepository.count());
        for(Extrato c : faturavelRepository.findAll()){
                listaObj.adiciona(c);
        }

        for(Extrato q: faturavelRepository.findAll()){
            if (q instanceof Receita) {
                listaReceitas.adiciona((Receita) q);
            }
        }
        for(Extrato e: faturavelRepository.findAll()){
            if (e instanceof Despesa) {
                listaDespesas.adiciona((Despesa) e);
            }
        }
        g.gravaArquivoCsv(listaObj, listaDespesas, listaReceitas, "relatorio");
        return ResponseEntity.status(204).build();
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
//    @GetMapping("/primeiroExtrato")
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

    @DeleteMapping("{id}")
    public ResponseEntity deleteWithDescription(@PathVariable Integer id) {

    List<Extrato> extrato = faturavelRepository.findAll();
    Iterator<Extrato> it = extrato.iterator();
    System.out.println("TAMANHO =" + extrato.size());
    Extrato ext = new Extrato();
        if (faturavelRepository.existsById(id)) {
            while (it.hasNext()) {
                ext = (Extrato) it.next();

                if(ext.getId().equals(id)) {
                    it.remove();
                    faturavelRepository.deleteById(id);
                }
            }
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(204).build();
        }
    }




    }




