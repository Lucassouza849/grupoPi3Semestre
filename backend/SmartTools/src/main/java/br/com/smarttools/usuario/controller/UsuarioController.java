package br.com.smarttools.usuario.controller;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity criarUsuario(@RequestBody Usuario novoUsuario) {
        usuarioRepository.save(novoUsuario);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public List<Usuario> obterUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable int id) {
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
    public ResponseEntity putUsuario(@PathVariable int id,@RequestBody Usuario usuarioAtualizado){
        if (usuarioRepository.existsById(id)){
            usuarioAtualizado.setId(id);
            usuarioRepository.save(usuarioAtualizado);
            return ResponseEntity.status(200).build();
        }else {
            return ResponseEntity.status(404).build();
        }
    }


    @PostMapping("/{nomeUsuario}/{senha}")
    public Usuario autenticarUsuario(@PathVariable String nomeUsuario, @PathVariable String senha) {

        for (Usuario usuario : usuarioRepository.findAll()) {
            if (usuario.autenticar(nomeUsuario, senha)) {
                return usuario;
            }
        }
        return null;
    }


}
