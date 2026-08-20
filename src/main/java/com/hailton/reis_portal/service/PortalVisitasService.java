package com.hailton.reis_portal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hailton.reis_portal.model.PortalVisitas;
import com.hailton.reis_portal.repository.PortalVisitasRepository;

@Service
public class PortalVisitasService {

    private static final Long ID_CONTADOR = 1L;

    private final PortalVisitasRepository repository;

    public PortalVisitasService(PortalVisitasRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Long registrarVisita() {

        PortalVisitas visitas = repository.findById(ID_CONTADOR)
                .orElseGet(() -> new PortalVisitas(ID_CONTADOR, 0L));

        visitas.setTotalVisitas(visitas.getTotalVisitas() + 1);

        repository.save(visitas);

        return visitas.getTotalVisitas();
    }

    @Transactional(readOnly = true)
    public Long obterTotalVisitas() {

        return repository.findById(ID_CONTADOR)
                .map(PortalVisitas::getTotalVisitas)
                .orElse(0L);
    }
}