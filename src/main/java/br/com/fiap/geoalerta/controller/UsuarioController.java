package br.com.fiap.geoalerta.controller;

import br.com.fiap.geoalerta.dto.UsuarioRequest;
import br.com.fiap.geoalerta.dto.UsuarioResponse;
import br.com.fiap.geoalerta.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioResponse cadastrar(@RequestBody UsuarioRequest dto) {
        return usuarioService.cadastrar(dto);
    }

    @GetMapping
    public Page<UsuarioResponse> listar(@PageableDefault(size = 10) Pageable pageable) {
        return usuarioService.listar(pageable);
    }

    @GetMapping("{id}")
    public UsuarioResponse buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("{id}")
    public UsuarioResponse atualizar(@PathVariable Long id, @RequestBody UsuarioRequest dto) {
        return usuarioService.atualizar(id, dto);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }
}
