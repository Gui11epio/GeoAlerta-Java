package br.com.fiap.geoalerta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {
    @Id
    private Long id;
    private String bairro;
    private String cidade;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
