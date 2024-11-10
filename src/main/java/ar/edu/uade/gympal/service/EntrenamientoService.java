package ar.edu.uade.gympal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.uade.gympal.model.rutina.Ejercicio;
import ar.edu.uade.gympal.model.rutina.Entrenamiento;

@Service
public class EntrenamientoService {
    public List<Entrenamiento> agruparEjercicios(List<Ejercicio> ejercicios, int entrenamientosPorSemana) {
        List<Entrenamiento> entrenamientos = new ArrayList<>();
        List<List<Ejercicio>> ejerciciosPorEntrenamiento = new ArrayList<>();

        for (int i = 0; i < entrenamientosPorSemana; i++) {
            ejerciciosPorEntrenamiento.add(new ArrayList<>());
        }

        for (int i = 0; i < ejercicios.size(); i++) {
            int numeroEntrenamiento = (ejercicios.size() - i) % entrenamientosPorSemana;
            ejerciciosPorEntrenamiento.get(numeroEntrenamiento).add(ejercicios.get(i));
        }

        for (int i = 0; i < entrenamientosPorSemana; i++) {
            entrenamientos.add(new Entrenamiento(ejerciciosPorEntrenamiento.get(i)));
        }

        return entrenamientos;
    }
}
