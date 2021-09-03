package br.com.smarttools.usuarioOficina.model;


public class UsuarioOficina {
    private Integer id;
    private String nome;
    private String cnpj;
    private String senha;
    private String usuario;
    private String telefone;
    private Boolean autenticado;

    public UsuarioOficina(Integer id, String nome, String cnpj, String senha, String usuario, String telefone, Boolean autenticado) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.senha = senha;
        this.usuario = usuario;
        this.telefone = telefone;
        this.autenticado = false;
    }

    public UsuarioOficina(){

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }
}
