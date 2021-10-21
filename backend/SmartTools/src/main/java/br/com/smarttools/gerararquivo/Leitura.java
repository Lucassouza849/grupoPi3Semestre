package br.com.smarttools.gerararquivo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Leitura {

    public void leExibeArquivoCsv (String nomeArq) {
        FileReader arq = null;      // objeto que representa o arquivo para leitura
        Scanner entrada = null;     // objeto usado para ler do arquivo
        Boolean deuRuim = false;

        nomeArq += ".csv";          // acrescenta a extensão .csv ao nome do arquivo

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try-catch para ler do arquivo
        try {
            System.out.printf("%5s %9s %4s %4s %2s %7s %2s %5s\n","DESC.", "CATEGORIA", "DATA",
                     "ID", "ENTRADA", "ID", "SAIDA");
            while (entrada.hasNext()) {
                String desc = entrada.next();
                String categoria = entrada.next();
                String data = entrada.next();
                Integer id = entrada.nextInt();
                Double entradas = entrada.nextDouble();
                Double saida = entrada.nextDouble();
                System.out.printf("%10s %9 %4s %4s %2d %7.2f %2d %5.2f\n",desc, categoria, data,
                        id, entradas, id, saida);
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }
}
