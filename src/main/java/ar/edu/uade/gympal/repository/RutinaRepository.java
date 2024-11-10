package ar.edu.uade.gympal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.uade.gympal.model.rutina.Rutina;

public interface RutinaRepository extends JpaRepository<Rutina, Long> {
}
