package ar.edu.uade.gympal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.uade.gympal.model.rutina.EjercicioBase;

public interface EjercicioBaseRepository extends JpaRepository<EjercicioBase, Long> {
}
