package br.com.smarttools.financeiro.repository;

import br.com.smarttools.financeiro.model.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoRepository extends JpaRepository<Saldo, Integer> {

}
