package br.com.fiap.geoalerta.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
