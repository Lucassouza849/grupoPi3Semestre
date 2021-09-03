package br.com.smarttools.usuarioOficina.model;

import java.time.LocalDateTime;

public class UsuarioDto {
    private String usuario;
    private LocalDateTime autenticadoEm;
    private Boolean autenticado;

    public UsuarioDto(UsuarioOficina usuarioOficina) {
        this.usuario =  usuarioOficina.getUsuario();
        this.autenticado = false;
    }

    public UsuarioDto(){

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getAutenticadoEm() {
        return autenticadoEm;
    }

    public void setAutenticadoEm(LocalDateTime autenticadoEm) {
        this.autenticadoEm = autenticadoEm;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }
}
