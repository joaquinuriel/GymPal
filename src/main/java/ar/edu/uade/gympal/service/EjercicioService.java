package ar.edu.uade.gympal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uade.gympal.dto.ParametrosRutina;
import ar.edu.uade.gympal.model.rutina.Ejercicio;
import ar.edu.uade.gympal.model.rutina.EjercicioBase;
import ar.edu.uade.gympal.repository.EjercicioBaseRepository;
import ar.edu.uade.gympal.repository.EjercicioRepository;

@Service

public class EjercicioService {
    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Autowired
    private EjercicioBaseRepository baseRepository;

    public List<EjercicioBase> obtenerCandidatos(ParametrosRutina params) {
        List<EjercicioBase> todos = baseRepository.findAll();
        return todos
                .stream()
                .filter(base -> base.grupoMuscular == params.grupoMuscular()
                        && base.nivelAerobico <= params.nivelAerobico()[0]
                        && base.nivelAerobico >= params.nivelAerobico()[1]
                        && base.nivelExigenciaMuscular <= params.exigenciaMuscular()[0]
                        && base.nivelExigenciaMuscular >= params.exigenciaMuscular()[1])
                .toList();
    }

    public List<Ejercicio> obtenerTodos() {
        return ejercicioRepository.findAll();
    }
}
