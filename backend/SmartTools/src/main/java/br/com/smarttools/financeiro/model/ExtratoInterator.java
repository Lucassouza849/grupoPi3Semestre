package br.com.smarttools.financeiro.model;

import br.com.smarttools.financeiro.repository.InteratorClass;

import java.util.ArrayList;
import java.util.List;

public class ExtratoInterator implements InteratorClass {

    private List<Double> receita = new ArrayList<>();
    private List<Extrato> extratos = new ArrayList<>();
    private Integer currentPosition = 0;
    Extrato e = new Extrato();

    public void createData(){
        if(e.getReceitas() == 0 ){
            for(Double d: receita){
                receita.add(e.getReceitas());
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
}
