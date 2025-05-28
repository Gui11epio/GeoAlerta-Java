package br.com.fiap.geoalerta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertaResponse {
    private String nivelRisco;
    private String descricao;
    private int probabilidade;
}
