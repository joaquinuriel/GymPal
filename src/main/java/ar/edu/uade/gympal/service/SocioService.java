package ar.edu.uade.gympal.service;


import ar.edu.uade.gympal.dto.SocioDTO;
import org.springframework.stereotype.Service;

import ar.edu.uade.gympal.model.Socio;
import ar.edu.uade.gympal.repository.SocioRepository;

@Service
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public SocioDTO obtenerSocioPorId(Long id) {
        Socio socio = socioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));
        // Conversión de entidad a DTO
        return convertirASocioDTO(socio);
    }

    private SocioDTO convertirASocioDTO(Socio socio) {
        SocioDTO dto = new SocioDTO();
        dto.setId(socio.getId());
        dto.setNombre(socio.getNombre());
        dto.setEdad(socio.getEdad());
        dto.setPeso(socio.getPeso());
        dto.setAltura(socio.getAltura());
        dto.setObjetivo(socio.getObjetivo() != null ? socio.getObjetivo().toString() : null); // Conversión según necesidad
        dto.setRutinasCompletadas(socio.getRutinasCompletadas());
        dto.setProgresoObjetivo(socio.getProgresoObjetivo());
        return dto;
    }
}
