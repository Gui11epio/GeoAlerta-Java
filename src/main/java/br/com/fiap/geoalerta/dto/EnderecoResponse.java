package br.com.fiap.geoalerta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {
    private Long id;
    private String bairro;
    private String cidade;
}
