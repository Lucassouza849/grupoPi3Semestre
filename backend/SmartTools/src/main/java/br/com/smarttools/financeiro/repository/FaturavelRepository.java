package br.com.smarttools.financeiro.repository;

import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.receitasresposta.TotalReceitasResposta;
import br.com.smarttools.veiculo.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FaturavelRepository extends JpaRepository<Extrato, Integer>{
//    List<Extrato> findByDate(LocalDateTime date);
//    Optional<Extrato> findByValor(Double valor);

  @Query("select v from Veiculo v where v.fk_usuario = : id_usuario")
    public List<Veiculo>listaVeiculo(@Param("id") Integer id);
}
