package br.com.smarttools.financeiro.model;

import java.time.LocalDateTime;

public class Saida extends Extrato{
    private Double valorSaida;

    public Saida(LocalDateTime data, Double valor, String descricao) {
        super(data, valor, descricao);
    }

    public Saida() {
    }

    @Override
    public Double getValorTotal() {
        return super.getValor() - valorSaida;
    }

    public Double getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(Double valorSaida) {
        this.valorSaida = valorSaida;
    }
}
