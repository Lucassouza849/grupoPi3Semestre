package br.com.smarttools.cliente.model;

import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.usuario.model.Usuario;
import br.com.smarttools.veiculo.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tb_cliente")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_cliente")
    private Integer id;
    @Column(name = "nome_cliente")
    private String nome;
    @Column(name = "telefone_cliente")
    private String telefone;
    @Column(name = "email_cliente")
    private String email;
    @ManyToOne
    private Usuario usuario;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {return usuario;}

    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
}
