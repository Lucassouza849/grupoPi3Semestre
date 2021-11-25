package br.com.smarttools.financeiro.model;

import br.com.smarttools.oficina.model.Oficina;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@DiscriminatorColumn(name="tipo_extrato")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_Extrato")
@Entity
public class Extrato{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_extrato")
    private Integer id;
    @Column(name = "data_registro_extrato")
    private LocalDateTime dataRegistro;
    @Column(name = "valor_lancamento_extrato")
    private Double valorLancamento;
    @Column(name = "descricao_extrato")
    private String descricao;
    @Column(name = "categoria_extrato")
    private String categoria;


    public Double getValorLancamento() {return valorLancamento;}

    public void setValorLancamento(Double valorLancamento) {this.valorLancamento = valorLancamento;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Extrato{" +
                "id=" + id +
                ", dataRegistro=" + dataRegistro +
                ", valorLancamento=" + valorLancamento +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
