package br.com.fiap.geoalerta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosClimaticosRequest {
    private double chuva;
    private double umidade;
    private double temperatura;
    private double vento;
    private double nuvens;
    private double pressao;
    private Long usuarioId;
    private Long enderecoId;
}
