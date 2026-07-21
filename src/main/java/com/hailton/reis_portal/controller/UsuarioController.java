package com.hailton.reis_portal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.hailton.reis_portal.dto.auth.UsuarioLogadoResponse;
import com.hailton.reis_portal.dto.usuario.UsuarioRequest;
import com.hailton.reis_portal.model.Usuario;
import com.hailton.reis_portal.security.CustomUserDetails;
import com.hailton.reis_portal.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/me")
    public UsuarioLogadoResponse me(Authentication authentication) {

        CustomUserDetails userDetails =
                (CustomUserDetails) authentication.getPrincipal();

        Usuario usuario = userDetails.getUsuario();

        return new UsuarioLogadoResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getRole().name()
        );
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody UsuarioRequest request) {
    	usuarioService.criar(request);
    }
}