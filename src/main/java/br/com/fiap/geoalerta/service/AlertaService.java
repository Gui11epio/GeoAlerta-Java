package br.com.fiap.geoalerta.service;

import br.com.fiap.geoalerta.dto.AlertaResponse;
import br.com.fiap.geoalerta.dto.DadosClimaticosRequest;
import br.com.fiap.geoalerta.model.Alerta;
import br.com.fiap.geoalerta.model.Endereco;
import br.com.fiap.geoalerta.model.NivelRisco;
import br.com.fiap.geoalerta.model.Usuario;
import br.com.fiap.geoalerta.repository.AlertaRepository;
import br.com.fiap.geoalerta.repository.EnderecoRepository;
import br.com.fiap.geoalerta.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public class AlertaService {

    private final UsuarioRepository usuarioRepository;

    private final AlertaRepository alertaRepository;

    private final EnderecoRepository enderecoRepository;

    public AlertaService(UsuarioRepository usuarioRepository, AlertaRepository alertaRepository, EnderecoRepository enderecoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.alertaRepository = alertaRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public AlertaResponse calcularAlerta(DadosClimaticosRequest dados) {
        int pontos = 0;
        if (dados.getChuva() >= 10) pontos += 3;
        else if (dados.getChuva() >= 5) pontos += 2;
        else if (dados.getChuva() >= 1) pontos += 1;

        if (dados.getUmidade() > 80) pontos += 2;
        else if (dados.getUmidade() >= 60) pontos += 1;

        if (dados.getVento() > 10) pontos += 2;
        else if (dados.getVento() >= 5) pontos += 1;

        if (dados.getNuvens() > 70) pontos += 1;
        if (dados.getPressao() < 1000) pontos += 1;

        NivelRisco nivel;
        String descricao;
        int probabilidade;

        if (pontos <= 2) {
            nivel = NivelRisco.MUITO_BAIXO;
            descricao = "Sem riscos. Condições estáveis.";
            probabilidade = 5;
        } else if (pontos <= 4) {
            nivel = NivelRisco.BAIXO;
            descricao = "Chuvas leves. Nenhum risco visível.";
            probabilidade = 15;
        } else if (pontos <= 6) {
            nivel = NivelRisco.MODERADO;
            descricao = "Condições que merecem atenção.";
            probabilidade = 40;
        } else if (pontos <= 8) {
            nivel = NivelRisco.ALTO;
            descricao = "Risco relevante de deslizamento.";
            probabilidade = 70;
        } else {
            nivel = NivelRisco.CRITICO;
            descricao = "Risco crítico. Ações imediatas recomendadas.";
            probabilidade = 90;
        }

        Usuario usuario = usuarioRepository.findById(dados.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Endereco endereco = enderecoRepository.findById(dados.getEnderecoId())
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        Alerta alerta = new Alerta();
        alerta.setNivelRisco(NivelRisco.valueOf(nivel.name()));
        alerta.setDescricao(descricao);
        alerta.setProbabilidade(probabilidade);
        alerta.setDataHora(LocalDateTime.now());
        alerta.setUsuario(usuario);
        alerta.setEndereco(endereco);
        alertaRepository.save(alerta);

        return new AlertaResponse(nivel.name(), descricao, probabilidade);
    }
}
