package ar.edu.uade.gympal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.uade.gympal.model.Medicion;

public interface MedicionRepository extends JpaRepository<Medicion, Long> {
}
