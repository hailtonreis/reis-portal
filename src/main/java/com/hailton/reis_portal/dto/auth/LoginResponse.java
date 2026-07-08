package com.hailton.reis_portal.dto.auth;

public class LoginResponse {

    private String token;
    private String tipo;
    private String username;
    private String nome;
    private String role;

    public LoginResponse() {
    }

    public LoginResponse(String token,
                         String tipo,
                         String username,
                         String nome,
                         String role) {

        this.token = token;
        this.tipo = tipo;
        this.username = username;
        this.nome = nome;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}