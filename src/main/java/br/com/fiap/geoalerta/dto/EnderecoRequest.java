package br.com.fiap.geoalerta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {
    @NotBlank(message = "O bairro é obrigatório")
    @Size(min = 2, max = 50, message = "O bairro deve ter entre 2 e 50 caracteres")
    private String bairro;

    @NotBlank(message = "A cidade é obrigatória")
    @Size(min = 2, max = 50, message = "A cidade deve ter entre 2 e 50 caracteres")
    private String cidade;

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long usuarioId;
}
