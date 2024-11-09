package ar.edu.uade.gympal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.uade.gympal.model.rutina.Ejercicio;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {
}
