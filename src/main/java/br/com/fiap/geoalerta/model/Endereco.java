package br.com.fiap.geoalerta.model;

import jakarta.persistence.*;


@Entity
@Table(name = "ENDERECO")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bairro;
    private String cidade;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Endereco() {
    }

    public Endereco(Long id, String bairro, String cidade, Usuario usuario) {
        this.id = id;
        this.bairro = bairro;
        this.cidade = cidade;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
