package br.com.smarttools.cadastroAutenticacao.Controller;

import br.com.smarttools.cadastroAutenticacao.Model.UserLogin;
import br.com.smarttools.cadastroAutenticacao.Repository.LoginRespository;
import br.com.smarttools.cadastroAutenticacao.Service.UserLoginAutenticar;
import br.com.smarttools.cadastroAutenticacao.dto.UserAutenticateDto;
import br.com.smarttools.cadastroAutenticacao.dto.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAutenticateController {

    private UserLoginAutenticar userLoginAutenticar;

    @Autowired
    public UserAutenticateController(UserLoginAutenticar userLoginAutenticar) {
        this.userLoginAutenticar = userLoginAutenticar;
    }

    public UserAutenticateController(){

    }

    @PostMapping("/autenticar")
    public ResponseEntity<UserAutenticateDto> autenticar(@RequestBody UserLoginDto userLoginDto, @RequestHeader String authorization) {
        UserLogin userLogin = userLoginAutenticar.autenticar(userLoginDto, authorization);
        return new ResponseEntity<UserAutenticateDto>(UserAutenticateDto.toDto(userLogin, "Bearer "), HttpStatus.ACCEPTED);
    }
}
