package br.com.fiap.geoalerta.dto;

public class EnderecoResponse {
    private Long id;
    private String bairro;
    private String cidade;

    public EnderecoResponse() {
    }

    public EnderecoResponse(Long id, String bairro, String cidade) {
        this.id = id;
        this.bairro = bairro;
        this.cidade = cidade;
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
}
