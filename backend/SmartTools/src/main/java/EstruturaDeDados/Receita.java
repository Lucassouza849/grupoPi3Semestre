package EstruturaDeDados;

import java.time.LocalDateTime;

public class Receita extends Extrato {
    private String categoriareceita;


    //construtor
    public Receita(LocalDateTime data, Double valor, String descricao, String categoriareceita) {
        super(data, valor, descricao);
        this.categoriareceita = categoriareceita;
    }


    //metodos

    @Override
    public Double getvalorTotal() {
        return getvalorTotal() + getValor();
    }


    @Override
    public String toString() {
        return "Receita{" +
                "categoriareceita='" + categoriareceita + '\'' +
                "Valor Total='" + getvalorTotal() + '\'' +
                "} " + super.toString();
    }
}
