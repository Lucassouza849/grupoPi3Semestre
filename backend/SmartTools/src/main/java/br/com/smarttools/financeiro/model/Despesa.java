package br.com.smarttools.financeiro.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Despesa extends Extrato {
    public Double saida;

    public Despesa(Integer id, LocalDateTime dataRegistro, String descricao, String categoria, Double saida) {
        super(id, dataRegistro, descricao, categoria);
        this.saida = saida;
    }

    public Despesa(){}

    public Double getSaida() {
        return saida;
    }

    public void setSaida(Double saida) {
        this.saida = saida;
    }
}
