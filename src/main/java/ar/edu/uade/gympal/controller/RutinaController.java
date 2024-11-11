package ar.edu.uade.gympal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.edu.uade.gympal.dto.ParametrosObjetivo;
import ar.edu.uade.gympal.model.rutina.Ejercicio;
import ar.edu.uade.gympal.model.rutina.EjercicioBase;
import ar.edu.uade.gympal.service.EjercicioService;

@RestController
@RequestMapping("/api/rutina")
public class RutinaController {
    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping("/ejercicios")
    public List<Ejercicio> obtenerEjercicios() {
        return ejercicioService.obtenerTodos();
    }

    @GetMapping("/candidatos")
    public List<EjercicioBase> obtenerCandidatos(@RequestBody ParametrosObjetivo parametrosRutina) {
        return ejercicioService.obtenerCandidatos(parametrosRutina);
    }
}
