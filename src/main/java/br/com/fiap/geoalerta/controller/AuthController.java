package br.com.fiap.geoalerta.controller;

import br.com.fiap.geoalerta.dto.AuthDTO;
import br.com.fiap.geoalerta.dto.LoginResponse;
import br.com.fiap.geoalerta.model.Usuario;
import br.com.fiap.geoalerta.repository.UsuarioRepository;
import br.com.fiap.geoalerta.service.TokenService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
        if (usuario == null || !passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String token = tokenService.generateToken(usuario);
        return ResponseEntity.ok(new LoginResponse(token));
    }

}
