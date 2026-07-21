package com.hailton.reis_portal.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hailton.reis_portal.dto.usuario.UsuarioRequest;
import com.hailton.reis_portal.enums.Role;
import com.hailton.reis_portal.model.Usuario;
import com.hailton.reis_portal.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario criar(UsuarioRequest request) {

        if (usuarioRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username já cadastrado");
        }

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();

        usuario.setNome(request.getNome());
        usuario.setUsername(request.getUsername());
        usuario.setEmail(request.getEmail());

        usuario.setSenha(
                passwordEncoder.encode(request.getSenha())
        );

        usuario.setRole(Role.ROLE_USER);

        return usuarioRepository.save(usuario);
    }
}