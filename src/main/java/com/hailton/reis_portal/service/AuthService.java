package com.hailton.reis_portal.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.hailton.reis_portal.dto.auth.LoginRequest;
import com.hailton.reis_portal.dto.auth.LoginResponse;
import com.hailton.reis_portal.model.Usuario;
import com.hailton.reis_portal.security.CustomUserDetails;
import com.hailton.reis_portal.security.jwt.JwtService;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager,
                       JwtService jwtService) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {
    	
    	 System.out.println(">>> Entrou no AuthService.login");
    	 
    	 try {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getSenha()
                        )
                );

        System.out.println(">>> Autenticou");
        
        CustomUserDetails userDetails =
                (CustomUserDetails) authentication.getPrincipal();

        Usuario usuario = userDetails.getUsuario();

        String token = jwtService.gerarToken(usuario.getUsername());

        return new LoginResponse(
                token,
                "Bearer",
                usuario.getUsername(),
                usuario.getNome(),
                usuario.getRole().name()
        );
    	 } catch (Exception e) {
    	        e.printStackTrace();
    	        throw e;
    	    }

    }

}