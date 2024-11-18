package ar.edu.uade.gympal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uade.gympal.model.objetivo.Objetivo;
import ar.edu.uade.gympal.repository.ObjetivoRepository;

@Service
public class ObjetivoService {
    @Autowired
    private ObjetivoRepository objetivoRepository;

    public void guardarObjetivo(Objetivo objetivo) {
        objetivoRepository.save(objetivo);
    }
}
