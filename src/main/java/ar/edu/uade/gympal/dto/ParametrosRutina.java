package ar.edu.uade.gympal.dto;

import ar.edu.uade.gympal.model.rutina.GrupoMuscular;

public record ParametrosRutina(GrupoMuscular grupoMuscular, int[] nivelAerobico, int[] exigenciaMuscular) {
}
