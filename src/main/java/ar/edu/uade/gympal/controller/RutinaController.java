package ar.edu.uade.gympal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.gympal.model.rutina.Ejercicio;
import ar.edu.uade.gympal.model.rutina.Rutina;
import ar.edu.uade.gympal.service.EjercicioService;
import ar.edu.uade.gympal.service.RutinaService;

@RestController
@RequestMapping("/api/rutina")
public class RutinaController {

    @Autowired
    private RutinaService rutinaService;

    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping("/ejercicios")
    public List<Ejercicio> obtenerEjercicios() {
        return ejercicioService.obtenerTodos();
    }

    @GetMapping("/rutina/{id}")
    public Rutina obtenerRutina(@PathVariable Long id) {
        return rutinaService.ObtenerRutina(id);
    }

    @PostMapping("/finalizar/ejercicio/{id}")
    public void finalizarEjercicio(@PathVariable Long id) {
        Optional<Ejercicio> opcional = ejercicioService.obtenerPorId(id);
        if (opcional.isPresent()) {
            Ejercicio ejercicio = opcional.get();
            ejercicio.finalizarEjercicio();
        }
    }

}
