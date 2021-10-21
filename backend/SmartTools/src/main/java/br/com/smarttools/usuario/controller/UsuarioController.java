package br.com.smarttools.usuario.controller;

import br.com.smarttools.cadastroAutenticacao.Exception.InvalidLoginException;
import br.com.smarttools.usuario.dto.UsuarioAutenticado;
import br.com.smarttools.usuario.dto.UsuarioResposta;
import br.com.smarttools.usuario.model.Usuario;
import br.com.smarttools.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastros")
    public ResponseEntity criarUsuario(@RequestBody Usuario novoUsuario) {
        novoUsuario.setAutenticado(false);
        usuarioRepository.save(novoUsuario);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity obterUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(usuarios);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable int id) {
        return ResponseEntity.of(usuarioRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity putUsuario(@PathVariable int id, @RequestBody Usuario usuarioAtualizado) {
        if (usuarioRepository.existsById(id)) {
            usuarioAtualizado.setId(id);
            usuarioRepository.save(usuarioAtualizado);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }


    @PostMapping("/autenticacoes")
    public ResponseEntity<UsuarioResposta> autenticarUsuario(@RequestBody UsuarioAutenticado usuarioAutenticado)  {
           Usuario usuario = usuarioRepository.findByNomeUsuario(usuarioAutenticado.getLogin())
                   .orElseThrow(RuntimeException::new);
           if(usuarioAutenticado.getSenha().equals(usuario.getSenhaUsuario())){
               usuario.setAutenticado(true);
               UsuarioResposta usuarioResposta = new UsuarioResposta(usuario.getNomeUsuario(),
               usuario.getEmailUsuario(), usuario.getAutenticado());
               return ResponseEntity.status(200).body(usuarioResposta);
           }else{
               return ResponseEntity.status(204).build();
           }

    }




}
