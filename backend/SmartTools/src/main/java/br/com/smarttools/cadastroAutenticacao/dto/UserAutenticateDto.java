package br.com.smarttools.cadastroAutenticacao.dto;

import br.com.smarttools.cadastroAutenticacao.Model.UserLogin;

public class
UserAutenticateDto {
    private String tipo;
    private String nome;
    private String login;
    private String token;

    public UserAutenticateDto(String nome, String login, String token, String tipo) {

        this.nome = nome;
        this.login = login;
        this.token = token;
        this.tipo = tipo;
    }

    public UserAutenticateDto(){}

    public static UserAutenticateDto toDto(UserLogin userLogin, String tipo){
        return new UserAutenticateDto(userLogin.getNome(), userLogin.getLogin(), userLogin.getToken(), tipo);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }
}
