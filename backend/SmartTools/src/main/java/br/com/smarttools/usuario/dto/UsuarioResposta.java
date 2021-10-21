package br.com.smarttools.usuario.dto;

public class UsuarioResposta {
    private String nome;
    private String email;

    public UsuarioResposta(String nome, String email) {
        this.nome = nome;
        this.email = email;
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


}
