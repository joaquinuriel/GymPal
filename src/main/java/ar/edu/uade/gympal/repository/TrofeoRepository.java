package ar.edu.uade.gympal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.uade.gympal.model.trofeo.Trofeo;

@Repository
public interface TrofeoRepository extends JpaRepository<Trofeo, Long> {
}
