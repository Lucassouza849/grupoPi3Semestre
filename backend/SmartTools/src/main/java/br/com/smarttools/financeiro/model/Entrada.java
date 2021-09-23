//package br.com.smarttools.financeiro.model;
//
//import java.time.LocalDateTime;
//
//public class Entrada extends Extrato{
//    private Double valorEntrada;
//
//    public Entrada(LocalDateTime data, Double valor, String descricao, Double valorEntrada) {
//        super(data, valor, descricao);
//        this.valorEntrada = valorEntrada;
//    }
//
//    public Entrada(){
//
//    }
//
//    @Override
//    public Double getValorTotal() {
//        return getValor() + valorEntrada;
//    }
//
//    public Double getValorEntrada() {
//        return valorEntrada;
//    }
//
//    public void setValorEntrada(Double valorEntrada) {
//        this.valorEntrada = valorEntrada;
//    }
//
//
//}
