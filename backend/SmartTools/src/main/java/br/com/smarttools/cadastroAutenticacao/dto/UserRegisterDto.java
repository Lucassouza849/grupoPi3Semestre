package br.com.smarttools.cadastroAutenticacao.dto;

import br.com.smarttools.cadastroAutenticacao.Model.UserLogin;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserRegisterDto extends UserLogin{

    private Integer id;
    private String nome;
    private String login;
    private String senha;

    public UserRegisterDto(){}

    public UserRegisterDto(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public UserLogin toUser(){
        return new UserLogin(getNome(), getLogin(), getSenha());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
