package com.gremio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gremio.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}