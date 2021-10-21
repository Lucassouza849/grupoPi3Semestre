package br.com.smarttools.usuario.dto;

public class UsuarioAutenticado {
        private String login;
        private String senha;

    public UsuarioAutenticado(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public UsuarioAutenticado(){}

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
