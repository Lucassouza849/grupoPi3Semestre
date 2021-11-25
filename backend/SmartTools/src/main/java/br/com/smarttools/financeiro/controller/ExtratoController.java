package br.com.smarttools.financeiro.controller;

import br.com.smarttools.financeiro.model.Despesa;
import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.model.Receita;
import br.com.smarttools.financeiro.repository.FaturavelRepository;
import br.com.smarttools.gerararquivo.GravaLeArquivoTxt;
import br.com.smarttools.gerararquivo.Gravar;

import br.com.smarttools.listaObj.ListaObj;
import br.com.smarttools.listaObj.PilhaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/extratos")
@CrossOrigin
public class ExtratoController {

    @Autowired
    private FaturavelRepository faturavelRepository;
    PilhaObj<Extrato> pilha = new PilhaObj<Extrato>(1000);
    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    List<Extrato> listaExtrato = new ArrayList<>();
    int contador = 0;

//    @Scheduled(fixedDelay = SEGUNDO)
//    public void adicionaNoBanco() {

//    }

    @Scheduled(cron = "0/10 * * * * *")
    public void adicionaBancoTeste(){
        if(pilha.isEmpty()) {
            System.out.println("Pilha vazia");
        }else{
            pilha.exibe();

            for(int i = 0; i <= faturavelRepository.count(); i++){
                listaExtrato.add(pilha.pop());
                contador++;
                System.out.println("FOIIIIIII");
            }
        }
    }


    @Scheduled(cron = "0/9 * * * * *")
    public void mandaBanco() {
        if(!listaExtrato.isEmpty()){
            for(int i = 0; i < contador; i++){
                faturavelRepository.save(listaExtrato.get(i));
                System.out.println("OOOOOO disgrama");
            }
        }else {
            System.out.println("SEU BURRO");
        }
    }



    @PostMapping("/receitas")
    public ResponseEntity adicionarReceita(@RequestBody Receita novaReceita){
            novaReceita.setDataRegistro(LocalDateTime.now());
            pilha.push(novaReceita);
            return ResponseEntity.status(201).build();
    }

    @PostMapping("/despesas")
    public ResponseEntity adicionarDespesa(@RequestBody Despesa novaDespesa){
            novaDespesa.setDataRegistro(LocalDateTime.now());
            pilha.push(novaDespesa);
            return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity todosEntradas(){

        List<Extrato> extrato = faturavelRepository.findAll();

        if (pilha.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(extrato);
        }
    }

    @GetMapping("/txt")
    public ResponseEntity getTxt(){
        List<Extrato> lista = new ArrayList<>();
        GravaLeArquivoTxt grava = new GravaLeArquivoTxt();
        grava.gravaArquivoTxt(lista,"extrato.txt");
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/buscar-pilha")
    public ResponseEntity<Extrato> getExtratoUsingStack() {

        if (pilha.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        pilha.exibe();
        return ResponseEntity.status(200).build();
    }

    @PostMapping("adicionar-transacao/")
    public ResponseEntity<Extrato> postExtrato() {

        for(int i = 0; i < faturavelRepository.count(); i++) {
            pilha.push(faturavelRepository.getById(i));
        }

        return ResponseEntity.status(201).build();
    }

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