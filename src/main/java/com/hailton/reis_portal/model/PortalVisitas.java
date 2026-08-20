package com.hailton.reis_portal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_portal_visitas")
public class PortalVisitas {

    @Id
    private Long id;

    @Column(nullable = false)
    private Long totalVisitas;

    public PortalVisitas() {
    }

    public PortalVisitas(Long id, Long totalVisitas) {
        this.id = id;
        this.totalVisitas = totalVisitas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalVisitas() {
        return totalVisitas;
    }

    public void setTotalVisitas(Long totalVisitas) {
        this.totalVisitas = totalVisitas;
    }
}