package br.com.smarttools.usuarioOficina.controller;

import br.com.smarttools.usuarioOficina.model.UsuarioDto;
import br.com.smarttools.usuarioOficina.model.UsuarioOficina;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioOficinaController {

    private List<UsuarioOficina> listaUser;

    public UsuarioOficinaController() {
        this.listaUser = new ArrayList<>();
    }

    @GetMapping
    public List<UsuarioOficina> getUsers(){
        listaUser.stream()
                .sorted(Comparator.comparing(UsuarioOficina :: getId))
                .collect(Collectors.toList());
        return listaUser;
    }

    @PostMapping
    public String createUsers(@RequestBody UsuarioOficina createUser){
        createUser.setId(ThreadLocalRandom.current().nextInt(0 ,100));
        createUser.setAutenticado(false);
        listaUser.add(createUser);
        return String.format("o usuario %s foi criado com sucesso", createUser.getUsuario());
    }

    @PostMapping("/autenticar/{usuario}/{senha}")
    public UsuarioDto authenticateUsers(@PathVariable String usuario, @PathVariable String senha){
         UsuarioDto usuarioDto = null;
         for (UsuarioOficina u : listaUser){
             if (u.getUsuario().equals(usuario)){
                 if (u.getSenha().equals(senha)){
                     u.setAutenticado(true);
                     usuarioDto = new UsuarioDto(u);
                     usuarioDto.setAutenticado(true);
                     usuarioDto.setAutenticadoEm(LocalDateTime.now());
                 }
             }
         }
         return usuarioDto;
    }

    @DeleteMapping("/autenticar/{usuario}")
    public String logoffUser(@PathVariable String usuario){
        listaUser.remove(listaUser.stream()
                .filter(listaUser -> listaUser.getUsuario().equals(usuario))
                .findFirst().get());
        return String.format("Usuario %s saiu do sistema", usuario);
    }
}
