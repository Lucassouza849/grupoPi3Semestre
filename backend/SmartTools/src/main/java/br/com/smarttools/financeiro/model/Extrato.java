package br.com.smarttools.financeiro.model;

import br.com.smarttools.financeiro.repository.ExtratoRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
public class Extrato implements ExtratoRepository {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataRegistro;
    private Double valorLancamento;
//    private Double despesas;
//    private Double receitas;
    private String descricao;
    private String categoria;


    public Extrato(Integer id, LocalDateTime dataRegistro, String descricao, String categoria, Double valorLancamento) {
        this.id = id;
        this.dataRegistro = dataRegistro;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valorLancamento = valorLancamento;
    }

    public Extrato() {

    }


    public Double getValorLancamento() {return valorLancamento;}

    public void setValorLancamento(Double valorLancamento) {this.valorLancamento = valorLancamento;}

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
}
