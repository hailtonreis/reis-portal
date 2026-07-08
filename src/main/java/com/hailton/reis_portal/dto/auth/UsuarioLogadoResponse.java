package com.hailton.reis_portal.dto.auth;

public class UsuarioLogadoResponse {

    private Long id;
    private String nome;
    private String username;
    private String email;
    private String role;

    public UsuarioLogadoResponse() {
    }

    public UsuarioLogadoResponse(Long id,
                                 String nome,
                                 String username,
                                 String email,
                                 String role) {

        this.id = id;
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}