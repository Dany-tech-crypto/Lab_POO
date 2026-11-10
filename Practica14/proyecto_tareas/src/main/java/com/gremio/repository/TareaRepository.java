package com.gremio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gremio.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}