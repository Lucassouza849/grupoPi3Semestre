package br.com.smarttools.veiculo.model;

import br.com.smarttools.cliente.model.Cliente;
import br.com.smarttools.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tb_veiculo")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_veiculo")
    private Integer idVeiculo;
    @Column(name = "marca_veiculo")
    private String marcaVeiculo;
    @Column(name = "modelo_veiculo")
    private String modeloVeiculo;
    @Column(name = "tipo_veiculo")
    private String tipoVeiculo;
    @Column(name = "placa_veiculo")
    private String placaVeiculo;
    @ManyToOne
    private Usuario usuario;

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public Usuario getUsuario() {return usuario;}

    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
}
