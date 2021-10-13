package br.com.smarttools;

import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.repository.ExtratoIterator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SmartToolsApplication implements ExtratoIterator {

	private Double receitas;
	private List<Double> receita = new ArrayList<>();
	private List<Extrato> extratos = new ArrayList<>();
	private Integer currentPosition = 0;
	Extrato e = new Extrato();

	public void createData(){
		if(e.getReceitas() == 0 ){
			for(Double d: receita){
				receita.add(receitas);
			}
		}
	}

	@Override
	public Extrato getNext() {
		if(!hasNext()){
			return null;
		}

		Double a = receita.get(currentPosition);
		Extrato e = extratos.get(currentPosition);

		if (a == null){
			extratos.set(currentPosition,e);
		}
		currentPosition++;
		return e;
	}

	@Override
	public Boolean hasNext() {
		createData();
		return currentPosition < receita.size();
	}

	@Override
	public void reset() {
		currentPosition = 0;
	}

	public static void main(String[] args) {
		SpringApplication.run(SmartToolsApplication.class, args);
	}


}
