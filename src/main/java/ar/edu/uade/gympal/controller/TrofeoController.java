package ar.edu.uade.gympal.controller;

import ar.edu.uade.gympal.dto.TrofeoDTO;
import ar.edu.uade.gympal.service.TrofeoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trofeos")
public class TrofeoController {

    private final TrofeoService trofeoService;

    // Inyección de dependencia del servicio
    public TrofeoController(TrofeoService trofeoService) {
        this.trofeoService = trofeoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TrofeoDTO>> getTrofeos(@PathVariable Long id) {
        // Lógica para obtener trofeos asociados a un usuario
        List<TrofeoDTO> trofeos = trofeoService.obtenerTrofeosPorUsuarioId(id);
        return ResponseEntity.ok(trofeos);
    }
}
