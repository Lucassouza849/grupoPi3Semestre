package br.com.smarttools.usuario.resposta;

import br.com.smarttools.usuario.model.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {


    @Test
    @DisplayName("Construtor não deve mudar os atributos")
    void construtorNaoDeveMudarAtributos() {
        Usuario response = new Usuario("emailteste@hotmail.com");
        // verificações

        // verificando de email
        assertEquals("emailteste@hotmail.com", response.getEmailUsuario());

    }


}