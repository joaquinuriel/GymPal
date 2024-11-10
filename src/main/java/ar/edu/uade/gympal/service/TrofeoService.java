package ar.edu.uade.gympal.service;

import ar.edu.uade.gympal.dto.TrofeoDTO;
import ar.edu.uade.gympal.model.trofeo.Trofeo;
import ar.edu.uade.gympal.repository.TrofeoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrofeoService {

    private final TrofeoRepository trofeoRepository;

    public TrofeoService(TrofeoRepository trofeoRepository) {
        this.trofeoRepository = trofeoRepository;
    }

    public List<TrofeoDTO> obtenerTrofeosPorUsuarioId(Long id) {
        List<Trofeo> trofeos = trofeoRepository.findBySocioId(id);
        return trofeos.stream()
                .map(this::convertirATrofeoDTO)
                .collect(Collectors.toList());
    }

    private TrofeoDTO convertirATrofeoDTO(Trofeo trofeo) {
        TrofeoDTO dto = new TrofeoDTO();
        dto.setId(trofeo.getId());
        dto.setNombre(trofeo.getNombre());
        dto.setFecha(trofeo.getFechaOtorgamiento().toString());
        return dto;
    }

}
