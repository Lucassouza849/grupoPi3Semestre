package br.com.smarttools.usuario.dto;

public class UsuarioResposta {
    private String nome;
    private String email;
    private Boolean autenticado;

    public UsuarioResposta(String nome, String email, Boolean autenticado) {
        this.nome = nome;
        this.email = email;
        this.autenticado = autenticado;
    }

    public  UsuarioResposta(String nomeUsuario, String emailUsuario, boolean autenticado){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }
}
