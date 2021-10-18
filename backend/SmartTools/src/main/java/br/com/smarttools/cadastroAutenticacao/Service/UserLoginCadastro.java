package br.com.smarttools.cadastroAutenticacao.Service;

import br.com.smarttools.cadastroAutenticacao.Model.UserLogin;
import br.com.smarttools.cadastroAutenticacao.Repository.LoginRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginCadastro {
    private LoginRespository loginRespository;
    private TokenService tokenService;

    @Autowired
    public UserLoginCadastro(LoginRespository loginRespository, TokenService tokenService) {
        this.loginRespository = loginRespository;
        this.tokenService = tokenService;
    }

    public UserLogin Cadastrar(UserLogin userLogin){
        userLogin.setToken(tokenService.generateToken(userLogin));
        return loginRespository.save(userLogin);
    }

}
