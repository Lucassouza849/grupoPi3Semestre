package br.com.smarttools.cadastroAutenticacao.dto;

import br.com.smarttools.cadastroAutenticacao.Model.UserLogin;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class UserResponseDTO {
    private Integer id;
    private String nome;
    private String login;
    private String senha;

    public UserResponseDTO(){}

    public UserResponseDTO(Integer id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public static UserResponseDTO toDto(UserLogin userLogin){
        return new UserResponseDTO(userLogin.getId(), userLogin.getNome(), userLogin.getLogin(), userLogin.getSenha());
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
