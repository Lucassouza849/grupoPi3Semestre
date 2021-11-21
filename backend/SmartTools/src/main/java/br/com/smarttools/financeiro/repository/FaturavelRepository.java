package br.com.smarttools.financeiro.repository;

import br.com.smarttools.financeiro.model.Extrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FaturavelRepository extends JpaRepository<Extrato, Integer>{

//    List<Extrato> findByDate(LocalDateTime date);
//    Optional<Extrato> findByValor(Double valor);



}
