package br.com.smarttools.financeiro.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Despesas extends Extrato {
    public Double saida;

    public Despesas(Integer id, LocalDateTime dataRegistro, String descricao, String categoria, Double saida) {
        super(id, dataRegistro, descricao, categoria);
        this.saida = saida;
    }

    public Despesas(){}

    public Double getSaida() {
        return saida;
    }

    public void setSaida(Double saida) {
        this.saida = saida;
    }
}
