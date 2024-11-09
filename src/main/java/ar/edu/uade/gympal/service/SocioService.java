package ar.edu.uade.gympal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uade.gympal.model.Socio;
import ar.edu.uade.gympal.repository.SocioRepository;

@Service
public class SocioService {
    @Autowired
    private SocioRepository socioRepository;

    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }

    public Socio getSocioById(Long id) {
        return socioRepository.findById(id).orElse(null);
    }

    public Socio saveSocio(Socio socio) {
        return socioRepository.save(socio);
    }
}