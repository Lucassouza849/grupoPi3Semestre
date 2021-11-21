package br.com.smarttools.usuario.model;

import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.oficina.model.Oficina;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;
    @Column(name = "nome_usuario")
    private String nomeUsuario;
    @Column(name = "senha_usuario")
    private String senhaUsuario;
    @Column(name = "email_usuario")
    private String emailUsuario;
    @OneToOne
    private Oficina oficina;

    public Usuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }



    @JsonIgnore
    @Column(length = 20_000_000)
    private byte[] fotoPerfil;


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

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Oficina getOficina() {return oficina;}

    public void setOficina(Oficina oficina) {this.oficina = oficina;}
}
