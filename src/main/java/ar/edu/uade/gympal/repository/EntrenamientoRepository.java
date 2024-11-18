package ar.edu.uade.gympal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.uade.gympal.model.rutina.Entrenamiento;

public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Long> {
}