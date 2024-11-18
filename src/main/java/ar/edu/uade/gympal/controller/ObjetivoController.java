package ar.edu.uade.gympal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.gympal.dto.ParametrosObjetivo;
import ar.edu.uade.gympal.model.Medicion;
import ar.edu.uade.gympal.model.Socio;
import ar.edu.uade.gympal.model.objetivo.BajarDePeso;
import ar.edu.uade.gympal.model.objetivo.MantenerFigura;
import ar.edu.uade.gympal.model.objetivo.Objetivo;
import ar.edu.uade.gympal.model.objetivo.TonificarCuerpo;
import ar.edu.uade.gympal.model.rutina.Rutina;
import ar.edu.uade.gympal.service.ObjetivoService;
import ar.edu.uade.gympal.service.RutinaService;
import ar.edu.uade.gympal.service.SocioService;

@RestController
@RequestMapping("/api/objetivo")
public class ObjetivoController {
        @Autowired
        private ObjetivoService objetivoService;

        @Autowired
        private RutinaService rutinaService;

        @Autowired
        private SocioService socioService;

        @PostMapping("/elegir/{socioId}")
        public void elegirObjetivo(
                        @PathVariable Long socioId,
                        @RequestBody String tipoObjetivo,
                        @RequestBody float margenPeso) {
                Socio socio = socioService.getSocioById(socioId);
                Medicion inicial = socio.ultimaMedicion();
                Medicion ideal = socio.generarMedicionIdeal();
                Objetivo objetivo;

                switch (tipoObjetivo) {
                        case "BajarDePeso" -> objetivo = new BajarDePeso(socio, ideal.getPeso());
                        case "MantenerFigura" -> objetivo = new MantenerFigura(socio, inicial.getPeso(), margenPeso);
                        case "TonificarCuerpo" ->
                                objetivo = new TonificarCuerpo(socio,
                                                ideal.getMasaMuscular(),
                                                ideal.getPorcentajeGrasa());
                        default -> throw new AssertionError();
                }

                Rutina rutina = rutinaService.armarRutina(
                                new ParametrosObjetivo(
                                                new int[] {
                                                                objetivo.getNivelAerobicoMin(),
                                                                objetivo.getNivelAerobicoMax()
                                                },
                                                new int[] {
                                                                objetivo.getNivelEjercitacionMuscularMin(),
                                                                objetivo.getNivelEjercitacionMuscularMax()
                                                },
                                                socio.getEntrenamientosPorSemana()));

                objetivo.setRutina(rutina);
                socio.setObjetivo(objetivo);

                objetivoService.guardarObjetivo(objetivo);
                rutinaService.guardarRutina(rutina); // guarda entrenamientos y ejercicios
                socioService.saveSocio(socio);
        }

}