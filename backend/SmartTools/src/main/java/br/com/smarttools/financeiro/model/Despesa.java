package br.com.smarttools.financeiro.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Despesa extends Extrato {

    @Column(name = "saida_despesa")
    public Double saida;

    public Double getSaida() {
        return saida;
    }

    public void setSaida(Double saida) {
        this.saida = saida;
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "saida=" + saida +
                "} " + super.toString();
    }
}
