package br.com.smarttools;

import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.model.ExtratoInterator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartToolsApplication {


	public static void main(String[] args) {
		SpringApplication.run(SmartToolsApplication.class, args);

		ExtratoInterator inter = new ExtratoInterator();
		Extrato extr = new Extrato();

		while(inter.hasNext()){
			if(extr.getDespesas() > 1){

			}
		}
	}


}
