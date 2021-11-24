//package br.com.smarttools.gerararquivo;
//
//import br.com.smarttools.financeiro.model.Despesa;
//import br.com.smarttools.financeiro.model.Extrato;
//import br.com.smarttools.financeiro.model.Receita;
//import br.com.smarttools.listaObj.ListaObj;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Formatter;
//import java.util.FormatterClosedException;
//
//public class Gravar {
//    public static void gravaArquivoCsv (ListaObj<Extrato> listaExtrato, ListaObj<Despesa> listaDespesas , ListaObj<Receita> listaReceitas, String nomeArq) {
//        FileWriter arq = null;   // objeto que representa o arquivo para escrita
//        Formatter saida = null;  // objeto que será usado para escrita no arquivo
//        Boolean deuRuim = false;
//
//        nomeArq += ".csv";       // acrescenta a extensão .csv ao nome do arquivo
//
//        // Bloco try-catch para abrir o arquivo
//        try {
//            // a criação do objeto FileWriter faz com que o arquivo seja aberto ou criado
//            arq = new FileWriter(nomeArq, true); // true é para acrescentar ao arquivo
//            saida = new Formatter(arq);
//        }
//        catch (IOException erro) {
//            System.out.println("Erro ao abrir o arquivo");
//            System.exit(1);
//        }
//
//        // Bloco try-catch para gravar no arquivo
//        try {
//            // Percorro a lista de cachorros
//            for (int i = 0; i < listaReceitas.getTamanho(); i++) {
//                // Obtenho um objeto dog da lista por vez (o do índice i)
//                Extrato e = listaExtrato.getElemento(i);
//                Receita r = listaReceitas.getElemento(i);
//                Despesa d = listaDespesas.getElemento(i);
//                // Gravo os dados desse objeto no arquivo
//                // Separando cada campo por um ;
//                saida.format("%s;%s;%s;%d;%.2f;%d,%.2f\n", e.getDescricao(), e.getCategoria(), e.getDataRegistro(),
//                        r.getId(), r.getValorEntrada(), d.getId(), d.getSaida());
//            }
//        }
//        catch (FormatterClosedException erro) {
//            System.out.println("Erro ao gravar arquivo");
//            deuRuim = true;
//        }
//        finally {
//            saida.close();
//            try {
//                arq.close();
//            }
//            catch (IOException erro) {
//                System.out.println("Erro ao fechar o arquivo");
//                deuRuim = true;
//            }
//            if (deuRuim) {
//                System.exit(1);
//            }
//        }
//    }
//}
