package br.com.smarttools.financeiro.model;

import br.com.smarttools.financeiro.repository.ExtratoRepository;
import br.com.smarttools.oficina.model.Oficina;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Extrato implements ExtratoRepository {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataRegistro;
//    private Double despesas;
//    private Double receitas;
    private String descricao;
    private String categoria;

    @ManyToOne
    private Oficina oficina;
    //private Receita receita;
   // private Despesa despesa;


    public Extrato(Integer id, LocalDateTime dataRegistro, String descricao, String categoria) {
        this.id = id;
        this.dataRegistro = dataRegistro;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public Extrato() {

    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
}
