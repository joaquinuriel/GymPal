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
        // Cálculo de masa muscular
        if (socio.getSexo().equalsIgnoreCase("Masculino")) {
            socio.setMasaMuscular((1.10 * socio.getPeso()) - (128 * Math.pow(socio.getPeso() / socio.getAltura(), 2)));
        } else if (socio.getSexo().equalsIgnoreCase("Femenino")) {
            socio.setMasaMuscular((1.07 * socio.getPeso()) - (148 * Math.pow(socio.getPeso() / socio.getAltura(), 2)));
        }

        // Cálculo del porcentaje de grasa
        double imc = socio.getPeso() / Math.pow(socio.getAltura() / 100.0, 2);
        if (socio.getSexo().equalsIgnoreCase("Masculino")) {
            socio.setPorcentajeGrasa((1.20 * imc) + (0.23 * socio.getEdad()) - 16.2);
        } else if (socio.getSexo().equalsIgnoreCase("Femenino")) {
            socio.setPorcentajeGrasa((1.20 * imc) + (0.23 * socio.getEdad()) - 5.4);
        }

        socioRepository.save(socio);
        return socio;
    }
}
