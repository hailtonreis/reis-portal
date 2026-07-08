package com.hailton.reis_portal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hailton.reis_portal.model.Usuario;
import com.hailton.reis_portal.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

	 public List<Usuario> listarTodos() {
	        return usuarioRepository.findAll();
	    }
	

}
