package ar.edu.uade.gympal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.uade.gympal.model.Socio;
import ar.edu.uade.gympal.service.SocioService;

@RestController
@RequestMapping("/api/socios")
@CrossOrigin(origins = "http://localhost:5173") // Permitir solicitudes desde tu frontend
public class SocioController {

    @Autowired
    private SocioService socioService;

    @PostMapping("/register")
    public ResponseEntity<String> registerSocio(@RequestBody Socio socio) {
        System.out.println("Datos recibidos: " + socio);
        socioService.saveSocio(socio); // Calcula campos y guarda el socio
        return ResponseEntity.status(HttpStatus.CREATED).body("Socio registrado exitosamente.");
    }


    @GetMapping
    public ResponseEntity<?> getAllSocios() {
        return ResponseEntity.ok(socioService.getAllSocios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSocioById(@PathVariable Long id) {
        Socio socio = socioService.getSocioById(id);
        if (socio != null) {
            return ResponseEntity.ok(socio);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Socio no encontrado.");
        }
    }

        @GetMapping("/{id}/medicion")
        public String añadirMedicion (@PathVariable Long id){
            Socio socio = socioService.getSocioById(id);
            String nombreTrofeo = socio.añadirMedicion();
            if (!nombreTrofeo.isEmpty())
                return "Ganaste un trofeo " + nombreTrofeo;
            else
                return "";
        }
    }
