package br.com.fiap.geoalerta.controller;

import br.com.fiap.geoalerta.dto.AuthDTO;
import br.com.fiap.geoalerta.dto.LoginResponse;
import br.com.fiap.geoalerta.model.Usuario;
import br.com.fiap.geoalerta.repository.UsuarioRepository;
import br.com.fiap.geoalerta.service.TokenService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    public AuthController(UsuarioRepository usuarioRepository, TokenService tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthDTO authDTO) {
        Usuario usuario = usuarioRepository.findByEmail(authDTO.email());
        System.out.println("Usuário encontrado: " + usuario);

        if (usuario == null) {
            System.out.println("Usuário não encontrado");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Gera um token do tipo UserPasswordAuthentication para esse usuário e senha
        var userPwd = new UsernamePasswordAuthenticationToken(
                authDTO.email(),
                authDTO.senha()
        );
        // Autentica o usuário
        var auth = this.authenticationManager.authenticate(userPwd);
        // Gera um token JWT
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));
    }

}
