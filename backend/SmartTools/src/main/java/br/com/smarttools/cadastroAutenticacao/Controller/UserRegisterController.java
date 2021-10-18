package br.com.smarttools.cadastroAutenticacao.Controller;

import br.com.smarttools.cadastroAutenticacao.Model.UserLogin;
import br.com.smarttools.cadastroAutenticacao.Service.UserLoginCadastro;
import br.com.smarttools.cadastroAutenticacao.dto.UserAutenticateDto;
import br.com.smarttools.cadastroAutenticacao.dto.UserRegisterDto;
import br.com.smarttools.cadastroAutenticacao.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterController {
    private UserLoginCadastro userLoginCadastro;

    @Autowired
    public UserRegisterController(UserLoginCadastro userLoginCadastro) {
        this.userLoginCadastro = userLoginCadastro;
    }


    @PostMapping("/user")
    public ResponseEntity<UserAutenticateDto> registrar(@RequestBody UserRegisterDto userRegisterDto){
        UserLogin userLogin = userLoginCadastro.Cadastrar(userRegisterDto.toUser());
        return new ResponseEntity<UserAutenticateDto>(UserAutenticateDto.toDto(userLogin, "Bearer "), HttpStatus.CREATED);
    }
}
