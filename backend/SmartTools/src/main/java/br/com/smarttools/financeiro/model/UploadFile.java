package br.com.smarttools.financeiro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_UploadFile")
@Entity
public class UploadFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_File")
    private Integer id;
    @Column(length = 50_000_000)
    private byte[] txt;

}
