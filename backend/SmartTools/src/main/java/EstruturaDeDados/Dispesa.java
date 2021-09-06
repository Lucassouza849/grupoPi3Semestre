package EstruturaDeDados;

import java.time.LocalDateTime;

public class Dispesa extends Extrato {
    private String categoriaDispesa;

    public Dispesa(LocalDateTime data, Double valor, String descricao, String categoriaDispesa) {
        super(data, valor, descricao);
        this.categoriaDispesa = categoriaDispesa;
    }


    @Override
    public Double getvalorTotal() {
        return getvalorTotal() - getValor();
    }

    @Override
    public String toString() {
        return "Dispesa{" +
                "categoriaDispesa='" + categoriaDispesa + '\'' +
                "Valor Total='" + getvalorTotal() + '\'' +
                "} " + super.toString();
    }
}
