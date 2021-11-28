package br.com.smarttools.usuario.controller;

import br.com.smarttools.usuario.dto.UsuarioAutenticado;
import br.com.smarttools.usuario.dto.UsuarioResposta;
import br.com.smarttools.usuario.model.Usuario;
import br.com.smarttools.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    List<UsuarioAutenticado> listaAutenticados = new ArrayList<>();

    @GetMapping("/list")
    public  ResponseEntity consulta(){
       return  ResponseEntity.status(200).body(listaAutenticados);
    }

    //cadastro do usuários
    @PostMapping("/cadastros")
    public ResponseEntity criarUsuario(@RequestBody Usuario novoUsuario) {
        usuarioRepository.save(novoUsuario);
        return ResponseEntity.status(201).build();
    }


    //listando todos os usuários
    @GetMapping
    public ResponseEntity obterUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(usuarios);
        }
    }

    //buscando usuário por id
    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable int id) {
        return ResponseEntity.of(usuarioRepository.findById(id));
    }


    //excluindo usuário da base
    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }


    //atualizando dados do usuário
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


    //autenticando o usuário
    @PostMapping("/autenticacoes")
    public ResponseEntity<UsuarioResposta> autenticarUsuario(@RequestBody UsuarioAutenticado usuarioAutenticado) {
        Usuario usuario = usuarioRepository.findByEmailUsuario(usuarioAutenticado.getLogin())
                .orElseThrow(RuntimeException::new);
        if (usuarioAutenticado.getSenha().equals(usuario.getSenhaUsuario())) {
            UsuarioResposta usuarioResposta = new UsuarioResposta(usuario.getNomeUsuario(),
                    usuario.getEmailUsuario());
            listaAutenticados.add(usuarioAutenticado);
            return ResponseEntity.status(200).body(usuarioResposta);
        } else {
            return ResponseEntity.status(204).build();
        }
    }

    @DeleteMapping("/logoff/{email}/{senha}")
    public ResponseEntity logoff(@PathVariable String email, @PathVariable String senha){
        UsuarioAutenticado usuarioAutenticado = null;
        for (UsuarioAutenticado u : listaAutenticados){
            if (u.getLogin().equals(email) && u.getSenha().equals(senha)) {
                listaAutenticados.remove(u);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(204).build();
    }


    //atualizando imagem do usuario
    @PatchMapping("/foto/{id}")
    public ResponseEntity atualizarAvatar(@PathVariable Integer id,
                                          @RequestParam MultipartFile foto) throws IOException {
        if (id != null) {
            Usuario usuario = usuarioRepository.findById(id).get();
            byte[] novaFoto = foto.getBytes();

            usuario.setFotoPerfil(novaFoto);
            usuarioRepository.save(usuario);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(204).build();
    }

    //Obtendo a imagem do usuario
    @GetMapping("/foto/{id}")
    public ResponseEntity obtendoImagemUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioRepository.findById(id).get();

        byte[] foto = usuario.getFotoPerfil();

        return ResponseEntity
                .status(200)
                .header("content-type", "image/jpeg")
                .body(foto);
    }

}
