package br.com.smarttools.financeiro.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Receita extends Extrato{
    private Double valorEntrada;

    public Receita(Integer id, LocalDateTime dataRegistro, String descricao, String categoria, Double valorEntrada) {
        super(id, dataRegistro, descricao, categoria);
        this.valorEntrada = valorEntrada;
    }

    public Receita(){}


    public Double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(Double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

}
