package ar.edu.uade.gympal.controller;

import ar.edu.uade.gympal.dto.SocioDTO;
import ar.edu.uade.gympal.service.SocioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioDTO> getSocio(@PathVariable Long id) {
        // Lógica para obtener un socio por su ID
        SocioDTO socio = socioService.obtenerSocioPorId(id);
        return ResponseEntity.ok(socio);
    }
}
