import br.com.smarttools.financeiro.controller.ExtratoController;
import br.com.smarttools.financeiro.model.Despesa;
import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.model.Receita;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import  static org.junit.jupiter.api.Assertions.*;

public class ExtratoTeste {

    Extrato extrato = new Extrato();
    ExtratoController ext = new ExtratoController();

//    @Test
//    public void testeAdicionarReceita() {
//        Receita rec = new Receita(extrato.getId(),extrato.getDataRegistro(),extrato.getDescricao(),extrato.getCategoria(), extrato.getValorLancamento());
//        assertTrue(rec.getDataRegistro() == LocalDateTime.now());
//        assertEquals(ResponseEntity.status(201).build(), ext.adicionarReceita(rec));
//    }

//    @Test
//    public void testeAdicionarDespesa() {
//        Despesa desp = new Despesa(extrato.getId(),extrato.getDataRegistro(),extrato.getDescricao(),extrato.getCategoria(), extrato.getValorLancamento());
//        assertEquals( ResponseEntity.status(201).build(), ext.adicionarDespesa(desp));
//    }


}
