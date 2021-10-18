package br.com.smarttools.cadastroAutenticacao.Service;

import br.com.smarttools.cadastroAutenticacao.Exception.ExistingLoginException;
import br.com.smarttools.cadastroAutenticacao.Exception.ExpiredTokenException;
import br.com.smarttools.cadastroAutenticacao.Exception.InvalidLoginException;
import br.com.smarttools.cadastroAutenticacao.Exception.InvalidTokenException;
import br.com.smarttools.cadastroAutenticacao.Model.UserLogin;
import br.com.smarttools.cadastroAutenticacao.Repository.LoginRespository;
import br.com.smarttools.cadastroAutenticacao.dto.UserLoginDto;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserLoginAutenticar {
    private final LoginRespository loginRespository;
    private TokenService tokenService;

    @Autowired
    public UserLoginAutenticar(LoginRespository loginRespository, TokenService tokenService) {
        this.loginRespository = loginRespository;
        this.tokenService = tokenService;
    }

    public UserLogin autenticar(UserLoginDto userLoginDto, String token) {
        UserLogin userLogin = loginRespository.findByLogin(userLoginDto.getLogin())
                .orElseThrow(ExistingLoginException::new);
        if(userLoginDto.getSenha().equals(userLogin.getSenha()) && !token.isEmpty() && validate(token)){
            return userLogin;
        }else{
            throw new InvalidLoginException();
        }
    }

    private boolean validate(String token){
        try {
            String tokenTratado = token.replace("Bearer ", "");

            Claims claims = tokenService.decodeToken(tokenTratado);
            System.out.println(claims.getIssuer());
            System.out.println(claims.getIssuedAt());

            //verifica se o token está expirado
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
            System.out.println(claims.getExpiration());
            return true;
        }catch(ExpiredTokenException et){
            et.printStackTrace();
            throw et;
        }catch(Exception e){
            e.printStackTrace();
            throw new InvalidTokenException();

        }

    }


}
