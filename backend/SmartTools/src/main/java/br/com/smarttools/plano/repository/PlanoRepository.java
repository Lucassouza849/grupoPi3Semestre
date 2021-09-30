package br.com.smarttools.plano.repository;

import br.com.smarttools.plano.domain.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoRepository extends JpaRepository<Plano, Integer> {
}
