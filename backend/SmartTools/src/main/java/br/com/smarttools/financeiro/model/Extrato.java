package br.com.smarttools.financeiro.model;

import br.com.smarttools.financeiro.repository.Faturavel;

import java.time.LocalDateTime;

public abstract class Extrato implements Faturavel {
    private LocalDateTime data;
    private Double valor;
    private String descricao;

    public Extrato(LocalDateTime data, Double valor, String descricao) {
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
    }
    public Extrato(){

    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
