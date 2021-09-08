//package EstruturaDeDados;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Oficina {
//    private Integer id;
//    private String cnpj;
//    private String endereco;
//    private Integer telefone;
//    List<Faturavel> lista;
//
//
//    public Oficina(Integer id, String cnpj, String endereco, Integer telefone) {
//        this.id = id;
//        this.cnpj = cnpj;
//        this.endereco = endereco;
//        this.telefone = telefone;
//        lista = new ArrayList<>();
//    }
//
//
//    public void AdicionarFaturavel(Faturavel f) {
//        lista.add(f);
//    }
//
//    public void exibirFaturavel() {
//        System.out.println("Lista de faturaveis: ");
//        for (Faturavel f : lista){
//            System.out.println(f);
//        }
//
//    }
//}
