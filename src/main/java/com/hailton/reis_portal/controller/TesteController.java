package com.hailton.reis_portal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hailton.reis_portal.security.jwt.JwtService;

@RestController
@RequestMapping("/teste")
public class TesteController {
	   private final JwtService jwtService;

	    public TesteController(JwtService jwtService) {
	        this.jwtService = jwtService;
	    }

	    @GetMapping("/token")
	    public String gerarToken() {
	        return jwtService.gerarToken("hailton");
	    }
}