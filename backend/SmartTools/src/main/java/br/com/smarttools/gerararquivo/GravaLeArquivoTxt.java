package br.com.smarttools.gerararquivo;

import br.com.smarttools.financeiro.model.Despesa;
import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.model.Receita;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GravaLeArquivoTxt {

    public static void gravaRegistro(String nomeArq, String registro) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException var5) {
            System.out.println("Erro na abertura do arquivo: " + var5.getMessage());
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException var4) {
            System.out.println("Erro na gravação do arquivo: " + var4.getMessage());
        }

    }

    public static void gravaArquivoTxt(List<Extrato> lista, String nomeArq) {
        int contaRegistro = 0;
        String header = "00EXTRATO";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header = header + formataData.format(dataDeHoje);
        header = header + "01";
        gravaRegistro(nomeArq, header);

        for(Iterator var7 = lista.iterator(); var7.hasNext(); ++contaRegistro) {
            Extrato e = (Extrato)var7.next();
            String corpo = "02";
            corpo = corpo + String.format("%-25.25s", e.getDescricao());
            corpo = corpo + String.format("%07.2f", e.getValorLancamento());
            corpo = corpo + String.format("%-19.19s", e.getDataRegistro());
            corpo = corpo + String.format("%-15.15s", e.getCategoria());
            gravaRegistro(nomeArq, corpo);
        }

        String trailer = "01";
        trailer = trailer + String.format("%010d", contaRegistro);
        gravaRegistro(nomeArq, trailer);
    }


    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        int contaRegDados = 0;
        ArrayList listaLida = new ArrayList();

        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException var15) {
            System.out.println("Erro na abertura do arquivo: " + var15.getMessage());
        }

        try {
            for(String registro = entrada.readLine(); registro != null; registro = entrada.readLine()) {
                String tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("Eh um header");
                    System.out.println("Tipo do arquivo: " + registro.substring(2, 6));
                    System.out.println("Ano/semestre: " + registro.substring(6, 11));
                    System.out.println("Data e hora de gravação: " + registro.substring(11, 30));
                    System.out.println("Versão do documento: " + registro.substring(30, 32));
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("Eh um trailer");
                    int qtdRegGravados = Integer.valueOf(registro.substring(2, 12));
                    if (qtdRegGravados == contaRegDados) {
                        System.out.println("Quantidade de registros lidos compatível com quantidade de registros gravados");
                    } else {
                        System.out.println("Quantidade de registros lidos incompatível com quantidade de registros gravados");
                    }
                } else if (tipoRegistro.equals("02")) {

                    System.out.println("Eh um registro de corpo");
                    
                    String curso = registro.substring(2, 7).trim();
                    String ra = registro.substring(7, 15);
                    String nome = registro.substring(15, 65).trim();
                    String disciplina = registro.substring(65, 105).trim();
                    Double media = Double.valueOf(registro.substring(105, 110).replace(',', '.'));
                    int qtdFalta = Integer.valueOf(registro.substring(110, 113));
                    Extrato e = new Extrato();
                    //Aluno a = new Aluno(ra, nome, curso, disciplina, media, qtdFalta);
                    listaLida.add(e);
                    ++contaRegDados;
                } else {
                    System.out.println("Tipo de registro inválido");
                }
            }

            entrada.close();
        } catch (IOException var16) {
            System.out.println("Erro ao ler arquivo: " + var16.getMessage());
        }

        System.out.println("\nConteúdo lido do arquivo:");
        Iterator var17 = listaLida.iterator();

        while(var17.hasNext()) {
            Extrato e = (Extrato) var17.next();
            System.out.println(e);
        }

    }

}
