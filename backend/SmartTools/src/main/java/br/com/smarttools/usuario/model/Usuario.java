package br.com.smarttools.usuario.model;

import br.com.smarttools.oficina.model.Oficina;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeUsuario;
    private String senhaUsuario;
    private String emailUsuario;
    private Boolean autenticado;

    public Usuario(Integer id, String nomeUsuario, String senhaUsuario, String emailUsuario, Boolean autenticado) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.emailUsuario = emailUsuario;
        this.autenticado = false;
    }

    public Boolean autenticar(String login, String senha) {
        if (login.equals(this.nomeUsuario) && senha.equals(this.senhaUsuario)) {
            this.autenticado = true;
            return true;
        }
        return false;
    }

    public Usuario(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
}
