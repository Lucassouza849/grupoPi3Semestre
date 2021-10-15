package br.com.smarttools.oficina.model;

import br.com.smarttools.usuario.model.Usuario;

import javax.persistence.*;

@Entity
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeOficina;
    private String cnpjOficina;
    @OneToOne
    private Usuario usuario;

    public Oficina(Integer id, String nomeOficina, String cnpjOficina, Usuario usuario) {
        this.id = id;
        this.nomeOficina = nomeOficina;
        this.cnpjOficina = cnpjOficina;
        this.usuario = usuario;
    }

    public Oficina(){}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeOficina() {
        return nomeOficina;
    }

    public void setNomeOficina(String nomeOficina) {
        this.nomeOficina = nomeOficina;
    }

    public String getCnpjOficina() {
        return cnpjOficina;
    }

    public void setCnpjOficina(String cnpjOficina) {
        this.cnpjOficina = cnpjOficina;
    }
}
