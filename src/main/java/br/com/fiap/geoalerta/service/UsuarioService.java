package br.com.fiap.geoalerta.service;

import br.com.fiap.geoalerta.dto.UsuarioRequest;
import br.com.fiap.geoalerta.dto.UsuarioResponse;
import br.com.fiap.geoalerta.model.Usuario;
import br.com.fiap.geoalerta.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponse cadastrar(UsuarioRequest dto) {
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuarioRepository.save(usuario);
        return modelMapper.map(usuario, UsuarioResponse.class);
    }


    public Page<UsuarioResponse> listar(Pageable pageable) {
        return usuarioRepository.findAll(pageable)
                .map(usuario -> modelMapper.map(usuario, UsuarioResponse.class));
    }


    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return modelMapper.map(usuario, UsuarioResponse.class);
    }


    public UsuarioResponse atualizar(Long id, UsuarioRequest dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setUser_name(dto.getUser_name());
        usuario.setSenha(dto.getSenha());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefone(dto.getTelefone());

        usuarioRepository.save(usuario);

        return modelMapper.map(usuario, UsuarioResponse.class);
    }


    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
