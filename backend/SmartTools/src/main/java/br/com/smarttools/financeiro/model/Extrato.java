package br.com.smarttools.financeiro.model;

import br.com.smarttools.oficina.model.Oficina;
import br.com.smarttools.usuario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@DiscriminatorColumn(name="tipo_extrato")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_Extrato")
@Entity
public class Extrato{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_extrato")
    private Integer id;
    @Column(name = "data_registro_extrato")
    private OffsetDateTime dataRegistro;
    @Column(name = "valor_lancamento_extrato")
    private Double valorLancamento;
    @Column(name = "descricao_extrato")
    private String descricao;
    @Column(name = "categoria_extrato")
    private String categoria;
    @JsonIgnore
    @Column(length = 50_000_000)
    private byte[] txt;
   


}
