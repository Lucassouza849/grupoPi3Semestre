package EstruturaDeDados;

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


    @Override
    public String toString() {
        return "Extrato{" +
                "data=" + data +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                '}';
    }


    public Double getValor() {
        return valor;
    }
}
