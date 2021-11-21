package br.com.smarttools.financeiro.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Receita extends Extrato{

    @Column(name = "valor_entrada_receita")
    private Double valorEntrada;

    public Double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(Double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

}
