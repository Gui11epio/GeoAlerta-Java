package br.com.fiap.geoalerta.controller;

import br.com.fiap.geoalerta.dto.EnderecoRequest;
import br.com.fiap.geoalerta.dto.EnderecoResponse;
import br.com.fiap.geoalerta.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    public EnderecoResponse cadastrar(@RequestBody EnderecoRequest dto) {
        return enderecoService.cadastrar(dto);
    }

    @GetMapping
    public Page<EnderecoResponse> listar(@PageableDefault(size = 10) Pageable pageable) {
        return enderecoService.listar(pageable);
    }

    @GetMapping("{id}")
    public EnderecoResponse buscarPorId(@PathVariable Long id) {
        return enderecoService.buscarPorId(id);
    }

    @PutMapping("{id}")
    public EnderecoResponse atualizar(@PathVariable Long id, @RequestBody EnderecoRequest dto) {
        return enderecoService.atualizar(id, dto);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        enderecoService.deletar(id);
    }
}
