package br.com.smarttools.financeiro.repository;

import br.com.smarttools.financeiro.model.Extrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturavelRepository extends JpaRepository<Extrato, Integer>{

}
