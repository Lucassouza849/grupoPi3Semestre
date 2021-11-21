package br.com.smarttools.financeiro.repository;

import br.com.smarttools.financeiro.model.Extrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FaturavelRepository extends JpaRepository<Extrato, Integer>{


}
