package br.com.fiap.geoalerta.dto;


public class AlertaResponse {
    private String nivelRisco;
    private String descricao;
    private int probabilidade;

    public AlertaResponse() {
    }

    public AlertaResponse(String nivelRisco, String descricao, int probabilidade) {
        this.nivelRisco = nivelRisco;
        this.descricao = descricao;
        this.probabilidade = probabilidade;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public void setNivelRisco(String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getProbabilidade() {
        return probabilidade;
    }

    public void setProbabilidade(int probabilidade) {
        this.probabilidade = probabilidade;
    }
}
