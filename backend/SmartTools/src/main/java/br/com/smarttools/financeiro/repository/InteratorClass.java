package br.com.smarttools.financeiro.repository;

import br.com.smarttools.financeiro.model.Extrato;

public interface InteratorClass {

    public Boolean hasNext();

    public Extrato getNext();

    public void reset();
}
