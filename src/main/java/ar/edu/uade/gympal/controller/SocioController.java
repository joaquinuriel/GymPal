package ar.edu.uade.gympal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.gympal.model.Socio;
import ar.edu.uade.gympal.service.SocioService;

@RestController
@RequestMapping("/api/socios")
public class SocioController {
    @Autowired
    private SocioService socioService;

    @GetMapping
    public List<Socio> getAllSocios() {
        return socioService.getAllSocios();
    }

    @GetMapping("/{id}")
    public Socio getSocioById(@PathVariable Long id) {
        return socioService.getSocioById(id);
    }

    @PostMapping
    public Socio createSocio(@RequestBody Socio socio) {
        return socioService.saveSocio(socio);
    }

    @GetMapping("/{id}/medicion")
    public String añadirMedicion(@PathVariable Long id) {
        Socio socio = socioService.getSocioById(id);
        String nombreTrofeo = socio.añadirMedicion();
        if (!nombreTrofeo.isEmpty())
            return "Ganaste un trofeo " + nombreTrofeo;
        else
            return "";
    }
}