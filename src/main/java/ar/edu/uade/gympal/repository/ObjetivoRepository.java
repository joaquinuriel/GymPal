package ar.edu.uade.gympal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.uade.gympal.model.objetivo.Objetivo;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Long> {
}