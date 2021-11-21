package br.com.smarttools.oficina.model;

import br.com.smarttools.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_oficina")
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oficina")
    private int id;
    @Column(name = "nome_oficina")
    private String nomeOficina;
    @Column(name = "cnpj_oficina")
    private String cnpjOficina;
    @Column(name = "telefone_oficina")
    private String telefoneOficina;

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

    public String getTelefoneOficina() {
        return telefoneOficina;
    }

    public void setTelefoneOficina(String telefoneOficina) {
        this.telefoneOficina = telefoneOficina;
    }
}
