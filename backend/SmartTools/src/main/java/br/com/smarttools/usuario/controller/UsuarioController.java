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
    public String criarUsuario(@RequestBody Usuario novoUsuario){
        usuarioRepository.save(novoUsuario);
        return "usuario criado com sucesso!";
    }

    @GetMapping
    public List<Usuario> obterUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable int id){
        return usuarioRepository.findById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable int id){
        usuarioRepository.deleteById(id);
        return "Usuario deletado com sucesso!";
    }

    @PostMapping("/{nomeUsuario}/{senha}")
    public Usuario autenticarUsuario(@PathVariable String nomeUsuario, @PathVariable String senha ){

        for (Usuario usuario : usuarioRepository.findAll()) {
            if (usuario.autenticar(nomeUsuario, senha)) {
                return usuario;
            }
        }
        return null;
    }


}
