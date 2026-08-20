package com.hailton.reis_portal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hailton.reis_portal.service.PortalVisitasService;

@RestController
@RequestMapping("/visitas")
public class PortalVisitasController {

    private final PortalVisitasService service;

    public PortalVisitasController(PortalVisitasService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Long> registrarVisita() {
        return ResponseEntity.ok(service.registrarVisita());
    }

    @GetMapping
    public ResponseEntity<Long> obterTotalVisitas() {
        return ResponseEntity.ok(service.obterTotalVisitas());
    }
}