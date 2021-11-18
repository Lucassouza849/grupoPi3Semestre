package br.com.smarttools.financeiro.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Despesa extends Extrato {
    public Double saida;

    public Despesa(Integer id, LocalDateTime dataRegistro, String descricao, String categoria, Double valorLancamento) {
        super(dataRegistro, descricao, categoria, valorLancamento);
        this.saida = valorLancamento;
    }

    public Despesa(){}

    public Double getSaida() {
        return saida;
    }

    public void setSaida(Double saida) {
        this.saida = saida;
    }
}
