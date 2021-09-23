package br.com.smarttools.usuario.model;

import br.com.smarttools.oficina.model.Oficina;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeUsuario;
    private String senhaUsuario;
    private String emailUsuario;
    @OneToOne
    private Oficina oficina;

    public Usuario(Integer id, String nomeUsuario, String senhaUsuario, String emailUsuario, Oficina oficina) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.emailUsuario = emailUsuario;
        this.oficina = oficina;
    }

    public Usuario(){}

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

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
