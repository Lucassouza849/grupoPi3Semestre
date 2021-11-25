package br.com.smarttools;

import br.com.smarttools.financeiro.model.Extrato;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmartToolsApplication {


	public static void main(String[] args) {
		SpringApplication.run(SmartToolsApplication.class, args);
	}


}
