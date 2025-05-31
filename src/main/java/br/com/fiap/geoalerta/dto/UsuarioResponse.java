package br.com.fiap.geoalerta.dto;


public class UsuarioResponse {
    private Long id;
    private String user_name;
    private String senha;
    private String email;
    private String telefone;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Long id, String user_name, String senha, String email, String telefone) {
        this.id = id;
        this.user_name = user_name;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
