package br.com.smarttools.veiculo.repository;

import br.com.smarttools.veiculo.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    List<Veiculo>findByCliente(String cliente);
    List<Veiculo>findByModelo(String modelo);
    List<Veiculo>findByPlaca(String placa);
}
