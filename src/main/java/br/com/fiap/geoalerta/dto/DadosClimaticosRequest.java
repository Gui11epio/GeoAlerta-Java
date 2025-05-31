package br.com.fiap.geoalerta.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class DadosClimaticosRequest {
    @Min(0)
    @Max(500)
    private double chuva;

    @Min(0)
    @Max(100)
    private double umidade;

    @Min(-50)
    @Max(60)
    private double temperatura;

    @Min(0)
    @Max(150)
    private double vento;

    @Min(0)
    @Max(100)
    private double nuvens;

    @Min(800)
    @Max(1100)
    private double pressao;

    @NotNull
    private Long usuarioId;

    @NotNull
    private Long enderecoId;

    public DadosClimaticosRequest() {
    }

    public DadosClimaticosRequest(double chuva, double umidade, double temperatura, double vento, double nuvens, double pressao, Long usuarioId, Long enderecoId) {
        this.chuva = chuva;
        this.umidade = umidade;
        this.temperatura = temperatura;
        this.vento = vento;
        this.nuvens = nuvens;
        this.pressao = pressao;
        this.usuarioId = usuarioId;
        this.enderecoId = enderecoId;
    }

    @Min(0)
    @Max(500)
    public double getChuva() {
        return chuva;
    }

    public void setChuva(@Min(0) @Max(500) double chuva) {
        this.chuva = chuva;
    }

    @Min(0)
    @Max(100)
    public double getUmidade() {
        return umidade;
    }

    public void setUmidade(@Min(0) @Max(100) double umidade) {
        this.umidade = umidade;
    }

    @Min(-50)
    @Max(60)
    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(@Min(-50) @Max(60) double temperatura) {
        this.temperatura = temperatura;
    }

    @Min(0)
    @Max(150)
    public double getVento() {
        return vento;
    }

    public void setVento(@Min(0) @Max(150) double vento) {
        this.vento = vento;
    }

    @Min(0)
    @Max(100)
    public double getNuvens() {
        return nuvens;
    }

    public void setNuvens(@Min(0) @Max(100) double nuvens) {
        this.nuvens = nuvens;
    }

    @Min(800)
    @Max(1100)
    public double getPressao() {
        return pressao;
    }

    public void setPressao(@Min(800) @Max(1100) double pressao) {
        this.pressao = pressao;
    }

    public @NotNull Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(@NotNull Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public @NotNull Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(@NotNull Long enderecoId) {
        this.enderecoId = enderecoId;
    }
}
