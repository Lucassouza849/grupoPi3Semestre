package br.com.smarttools.financeiro.controller;

import br.com.smarttools.financeiro.repository.FaturavelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ExtratoController.class, FaturavelRepository.class})
class ExtratoControllerTest {

    @Autowired
    ExtratoController controller;

    @MockBean
    FaturavelRepository repository;


    @Test
    void getDeveRetornarStatus204SemCorpo_seSemExtrato() {


        when(repository.findAll()).thenReturn(new ArrayList<>());


        ResponseEntity resposta = controller.todosEntradas();


        assertEquals(204, resposta.getStatusCodeValue());


        assertNull(resposta.getBody());
    }

    @Test
    void deleteDeveRetornarStatus404SemCorpo_seIdNaoExiste() {

        // Id de fruta usado neste teste
        Integer idTeste = 900;

        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método existsById()
        Nesse caso, estamos "ensinando" ele a retornar false
         */
        when(repository.existsById(idTeste)).thenReturn(false);

        // o patchPreco() do FrutaController acaba invocando o existsById() da FrutaRepository
        ResponseEntity resposta = controller.deleteWithDescription(idTeste);

        // Verificações

        // é 404 o código de status de resposta do endpoint?
        assertEquals(404, resposta.getStatusCodeValue());

        // é nulo o corpo da resposta do endpoint? Ou seja, o endpoint não devolveu nenhum corpo?
        assertNull(resposta.getBody());
    }



}