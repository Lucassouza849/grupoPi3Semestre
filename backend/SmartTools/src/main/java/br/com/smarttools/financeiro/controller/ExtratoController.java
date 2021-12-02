package br.com.smarttools.financeiro.controller;

import br.com.smarttools.financeiro.model.Despesa;
import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.model.Receita;
import br.com.smarttools.financeiro.model.UploadFile;
import br.com.smarttools.financeiro.receitasresposta.TotalReceitasResposta;
import br.com.smarttools.financeiro.repository.FaturavelRepository;
//import br.com.smarttools.gerararquivo.GravaLeArquivoTxt;
//import br.com.smarttools.gerararquivo.Gravar;

import br.com.smarttools.financeiro.repository.FileUploadService;
import br.com.smarttools.gerararquivo.GravaLeArquivoTxt;
import br.com.smarttools.listaObj.ListaObj;
import br.com.smarttools.listaObj.PilhaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
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

    @Autowired
    private FileUploadService fileRepository;

    PilhaObj<Extrato> pilha = new PilhaObj<Extrato>(1000);
    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    int contador = 0;


    @PostMapping("/receitas")
    public ResponseEntity adicionarReceita(@RequestBody Receita novaReceita){
            novaReceita.setDataRegistro(OffsetDateTime.now());
            pilha.push(novaReceita);
            return ResponseEntity.status(201).build();
    }

    @PostMapping("/despesas")
    public ResponseEntity adicionarDespesa(@RequestBody Despesa novaDespesa){
            novaDespesa.setDataRegistro(OffsetDateTime.now());
            pilha.push(novaDespesa);
            return ResponseEntity.status(201).build();
    }

    @Scheduled(cron = "0/30 * * * * *")
    public void adicionaBanco(){

        if(pilha.isEmpty()) {
            System.out.println("Pilha vazia");
        }else{
            while (!pilha.isEmpty()){
                System.out.println("Esvaziando a pilha....");
                faturavelRepository.save(pilha.pop());
                contador+= 1;
            }
        }
    }

    @GetMapping("/desfazer")
    public ResponseEntity desfazer() {

        if(pilha.isEmpty()) {
            System.out.println("Não há ação para desfazer");
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(pilha.pop());
        }

    }

    @GetMapping("/todos/{id}")
    public ResponseEntity extratPorId(@PathVariable Integer id){
        List<Extrato> extratos = faturavelRepository.findAll();
        List<Extrato> extratosPorUsuario = new ArrayList<>();
        if (!extratos.isEmpty()){
            for (Extrato extrato : extratos){
                if (extrato.getUsuario() != null && extrato.getUsuario().getId().equals(id)){
                    extratosPorUsuario.add(extrato);
                }
            }
            return ResponseEntity.status(200).body(extratosPorUsuario);
        }
        return ResponseEntity.status(204).build();
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


    @PostMapping("/upload")
    public ResponseEntity patchFoto(@RequestParam MultipartFile txt) throws IOException {

        UploadFile uploadFile = new UploadFile();

        byte[] novaArquivo = txt.getBytes();
        long tamanho = txt.getSize();

        String tipo = txt.getContentType();

        String nomeOriginal = txt.getOriginalFilename();

        uploadFile.setTxt(novaArquivo);

        fileRepository.save(uploadFile);

        return ResponseEntity.status(200).build();
    }

    @GetMapping("/upload")
    public ResponseEntity getAllFilesFromCloud() {

        List<UploadFile> uploadFiles = fileRepository.findAll();

        if (uploadFiles.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(uploadFiles);
        }

    }


    @GetMapping("/txt/{id}")
    public ResponseEntity getTxt(@PathVariable Integer id) {
        List<Extrato> extratos = faturavelRepository.findAll();
        List<Extrato> lista = new ArrayList<>();
        if (!extratos.isEmpty()) {
            for (Extrato extrato : extratos) {
                if (extrato.getUsuario() != null && extrato.getUsuario().getId().equals(id)) {
                    lista.add(extrato);
                }
            }
            GravaLeArquivoTxt grava = new GravaLeArquivoTxt();

            grava.gravaArquivoTxt(lista, "extrato.txt");

            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(204).build();
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
            return ResponseEntity.status(404).build();
        }
    }
}
