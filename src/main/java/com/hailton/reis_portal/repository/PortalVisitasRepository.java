package com.hailton.reis_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hailton.reis_portal.model.PortalVisitas;

@Repository
public interface PortalVisitasRepository extends JpaRepository<PortalVisitas, Long> {
}