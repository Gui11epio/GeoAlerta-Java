package br.com.fiap.geoalerta.service;

import br.com.fiap.geoalerta.dto.EnderecoRequest;
import br.com.fiap.geoalerta.dto.EnderecoResponse;
import br.com.fiap.geoalerta.model.Endereco;
import br.com.fiap.geoalerta.model.Usuario;
import br.com.fiap.geoalerta.repository.EnderecoRepository;
import br.com.fiap.geoalerta.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService{

    private final EnderecoRepository enderecoRepository;

    private final UsuarioRepository usuarioRepository;

    private final ModelMapper modelMapper;


    public EnderecoResponse cadastrar(EnderecoRequest dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Endereco endereco = new Endereco();
        endereco.setBairro(dto.getBairro());
        endereco.setCidade(dto.getCidade());
        endereco.setUsuario(usuario);

        enderecoRepository.save(endereco);
        return modelMapper.map(endereco, EnderecoResponse.class);
    }


    public Page<EnderecoResponse> listar(Pageable pageable) {
        return enderecoRepository.findAll(pageable)
                .map(endereco -> modelMapper.map(endereco, EnderecoResponse.class));
    }


    public EnderecoResponse buscarPorId(Long id) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        return modelMapper.map(endereco, EnderecoResponse.class);
    }


    public EnderecoResponse atualizar(Long id, EnderecoRequest dto) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        endereco.setBairro(dto.getBairro());
        endereco.setCidade(dto.getCidade());

        enderecoRepository.save(endereco);

        return modelMapper.map(endereco, EnderecoResponse.class);
    }


    public void deletar(Long id) {
        if (!enderecoRepository.existsById(id)) {
            throw new EntityNotFoundException("Endereço não encontrado");
        }
        enderecoRepository.deleteById(id);
    }
}
