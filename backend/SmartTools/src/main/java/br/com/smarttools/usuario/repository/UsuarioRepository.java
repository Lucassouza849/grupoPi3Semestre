package br.com.smarttools.usuario.repository;

import br.com.smarttools.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNomeUsuario(String nomeUsuario);
    Optional<Usuario> findByEmailUsuario(String email);

}
