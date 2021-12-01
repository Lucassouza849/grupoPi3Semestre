package br.com.smarttools.financeiro.repository;

import br.com.smarttools.financeiro.model.Extrato;
import br.com.smarttools.financeiro.model.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadService extends JpaRepository<UploadFile, Integer> {

}
