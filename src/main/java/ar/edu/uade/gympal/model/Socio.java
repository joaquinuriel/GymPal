package ar.edu.uade.gympal.model;

import jakarta.persistence.*;
import ar.edu.uade.gympal.model.objetivo.Objetivo;
import ar.edu.uade.gympal.model.rutina.Rutina;
import ar.edu.uade.gympal.model.trofeo.Trofeo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import ar.edu.uade.gympal.model.Medicion;

@Entity
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float masaMuscular; // Masa muscular del socio
    private float porcentajeGrasa; // Porcentaje de grasa del socio

    private String nombre;
    private int edad;
    private float peso;
    private float altura;
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medicion> mediciones = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Rutina rutina; // Relación con la entidad Rutina

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trofeo> trofeos = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "objetivo_id")
    private Objetivo objetivo;

    private int rutinasCompletadas;
    private int progresoObjetivo;

    public Socio() {}

    public Socio(String nombre, int edad, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public List<Trofeo> getTrofeos() {
        return trofeos;
    }

    public void setTrofeos(List<Trofeo> trofeos) {
        this.trofeos = trofeos;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public int getRutinasCompletadas() {
        return rutinasCompletadas;
    }

    public void setRutinasCompletadas(int rutinasCompletadas) {
        this.rutinasCompletadas = rutinasCompletadas;
    }

    public int getProgresoObjetivo() {
        return progresoObjetivo;
    }

    public void setProgresoObjetivo(int progresoObjetivo) {
        this.progresoObjetivo = progresoObjetivo;
    }

    public List<Medicion> getMediciones() {
        return mediciones;
    }

    public void setMediciones(List<Medicion> mediciones) {
        this.mediciones = mediciones;
    }
    public float getMasaMuscular() {
        return masaMuscular;
    }

    public void setMasaMuscular(float masaMuscular) {
        this.masaMuscular = masaMuscular;
    }

    // Getter y Setter para porcentaje de grasa
    public float getPorcentajeGrasa() {
        return porcentajeGrasa;
    }

    public void setPorcentajeGrasa(float porcentajeGrasa) {
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public void añadirTrofeo(Trofeo trofeo) {
        this.trofeos.add(trofeo);
        trofeo.setSocio(this);
    }

    public void removeTrofeo(Trofeo trofeo) {
        this.trofeos.remove(trofeo);
        trofeo.setSocio(null);
    }

    public Medicion ultimaMedicion() {
        if (mediciones == null || mediciones.isEmpty()) {
            throw new IllegalStateException("El socio no tiene mediciones registradas");
        }
        // Devuelve la última medición de la lista
        return mediciones.get(mediciones.size() - 1);
    }

    public int getCantidadPesajesEnUltimoMes() {
        int contadorPesajes = 0;

        // Obtener la fecha actual
        Date ahora = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ahora);
        calendar.add(Calendar.MONTH, -1); // Restar un mes
        Date haceUnMes = calendar.getTime();

        // Contar mediciones realizadas en el último mes
        for (Medicion medicion : mediciones) {
            if (medicion.getFechaMedicion().after(haceUnMes)) {
                contadorPesajes++;
            }
        }

        return contadorPesajes;
    }

    public boolean haCumplidoRutinaPerfectamente() {
        return this.rutina != null && this.rutina.esPerfecta();
    }
}
