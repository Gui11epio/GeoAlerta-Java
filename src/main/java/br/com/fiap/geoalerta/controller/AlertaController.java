package br.com.fiap.geoalerta.controller;

import br.com.fiap.geoalerta.dto.AlertaResponse;
import br.com.fiap.geoalerta.dto.DadosClimaticosRequest;
import br.com.fiap.geoalerta.service.AlertaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alerta")
public class AlertaController {

    private final AlertaService alertaService;

    @Autowired
    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @PostMapping
    public ResponseEntity<AlertaResponse> calcular(@RequestBody @Valid DadosClimaticosRequest request) {
        return ResponseEntity.ok(alertaService.calcularAlerta(request));
    }
}
