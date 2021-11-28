package br.com.smarttools.usuario.dto;

public class UsuarioResposta {
    private Integer id;
    private String nome;
    private String email;

    public UsuarioResposta(Integer id, String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.id = id;
    }

    public  UsuarioResposta(String nomeUsuario, String emailUsuario, boolean autenticado, Integer id){}

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
