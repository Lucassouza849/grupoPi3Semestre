package br.com.smarttools.cliente.repository;

import br.com.smarttools.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByEmail(String email);
    List<Cliente>findByNome(String nome);
    List<Cliente>findByTelefone(String telefone);
}
