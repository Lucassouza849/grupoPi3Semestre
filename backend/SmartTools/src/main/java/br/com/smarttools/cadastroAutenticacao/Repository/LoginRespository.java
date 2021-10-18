package br.com.smarttools.cadastroAutenticacao.Repository;

import br.com.smarttools.cadastroAutenticacao.Model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRespository extends JpaRepository<UserLogin, Integer> {



    Optional<UserLogin> findByLogin(String login);
}
