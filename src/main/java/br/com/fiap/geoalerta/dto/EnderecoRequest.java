package br.com.fiap.geoalerta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EnderecoRequest {
    @NotBlank(message = "O bairro é obrigatório")
    @Size(min = 2, max = 50, message = "O bairro deve ter entre 2 e 50 caracteres")
    private String bairro;

    @NotBlank(message = "A cidade é obrigatória")
    @Size(min = 2, max = 50, message = "A cidade deve ter entre 2 e 50 caracteres")
    private String cidade;

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long usuarioId;

    public EnderecoRequest() {
    }

    public EnderecoRequest(String bairro, String cidade, Long usuarioId) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.usuarioId = usuarioId;
    }

    public @NotBlank(message = "O bairro é obrigatório") @Size(min = 2, max = 50, message = "O bairro deve ter entre 2 e 50 caracteres") String getBairro() {
        return bairro;
    }

    public void setBairro(@NotBlank(message = "O bairro é obrigatório") @Size(min = 2, max = 50, message = "O bairro deve ter entre 2 e 50 caracteres") String bairro) {
        this.bairro = bairro;
    }

    public @NotBlank(message = "A cidade é obrigatória") @Size(min = 2, max = 50, message = "A cidade deve ter entre 2 e 50 caracteres") String getCidade() {
        return cidade;
    }

    public void setCidade(@NotBlank(message = "A cidade é obrigatória") @Size(min = 2, max = 50, message = "A cidade deve ter entre 2 e 50 caracteres") String cidade) {
        this.cidade = cidade;
    }

    public @NotNull(message = "O ID do usuário é obrigatório") Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(@NotNull(message = "O ID do usuário é obrigatório") Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
