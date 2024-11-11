package ar.edu.uade.gympal.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import ar.edu.uade.gympal.model.adapter.IAdapterBalanza;
import ar.edu.uade.gympal.model.adapter.IAdapterMedicion;
import ar.edu.uade.gympal.model.objetivo.Objetivo;
import ar.edu.uade.gympal.model.rutina.Rutina;
import ar.edu.uade.gympal.model.trofeo.Trofeo;
import ar.edu.uade.gympal.model.trofeo.TrofeoCreido;
import jakarta.persistence.*;

@Entity
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    private Integer edad;
    private String sexo; // "Femenino" o "Masculino"
    private Double peso;
    private Double altura;
    private Double masaMuscular; // Calculado automáticamente
    private Double porcentajeGrasa; // Calculado automáticamente
    private String progresoObjetivo;
    private Integer rutinasCompletadas;

    private int entrenamientosPorSemana;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<Medicion> mediciones = new ArrayList<>();

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<Trofeo> trofeos = new ArrayList<>();

    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
    private Objetivo objetivo;

    @OneToOne
    private Rutina rutina;

    @Transient
    private IAdapterBalanza adapterBalanza;

    @Transient
    private IAdapterMedicion adapterMedicion;

    @Transient
    private TrofeoCreido trofeoCreido;

    // Métodos de cálculo
    public Medicion ultimaMedicion() {
        return mediciones.isEmpty() ? null : mediciones.get(mediciones.size() - 1);
    }

    public boolean haCumplidoRutinaPerfectamente() {
        return this.rutina != null && this.rutina.esPerfecta();
    }

    public String añadirMedicion() {
        float peso = adapterBalanza.getPeso(this);
        float masaMuscular = adapterMedicion.getMasaMuscular(this);
        float porcentajeGrasa = adapterMedicion.getPorcentajeGrasa(this);
        Medicion medicion = new Medicion(peso, masaMuscular, porcentajeGrasa);
        mediciones.add(medicion);

        if (objetivo.estaCumplido()) {
            return "Trofeo Dedicacion";
        }
        if (trofeoCreido.verificarCriterio(this)) {
            return "Trofeo Creido";
        }
        return "";
    }

    public void añadirTrofeo(Trofeo trofeo) {
        this.trofeos.add(trofeo);
    }

    public int getCantidadPesajesEnUltimoMes() {
        int contadorPesajes = 0;
        Date ahora = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ahora);
        calendar.add(Calendar.MONTH, -1); // Fecha de un mes atrás
        Date haceUnMes = calendar.getTime();

        for (Medicion medicion : this.mediciones) {
            if (medicion.getFechaMedicion().after(haceUnMes)) {
                contadorPesajes++;
            }
        }
        return contadorPesajes;
    }

    public Medicion generarMedicionIdeal() {
        Random random = new Random();
        float pesoIdeal = 70 + random.nextFloat() * 10;
        float masaMuscularIdeal = 30 + random.nextFloat() * 10;
        float porcentajeGrasaIdeal = 10 + random.nextFloat() * 10;
        return new Medicion(pesoIdeal, masaMuscularIdeal, porcentajeGrasaIdeal);
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getMasaMuscular() {
        return masaMuscular;
    }

    public void setMasaMuscular(Double masaMuscular) {
        this.masaMuscular = masaMuscular;
    }

    public Double getPorcentajeGrasa() {
        return porcentajeGrasa;
    }

    public void setPorcentajeGrasa(Double porcentajeGrasa) {
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public String getProgresoObjetivo() {
        return progresoObjetivo;
    }

    public void setProgresoObjetivo(String progresoObjetivo) {
        this.progresoObjetivo = progresoObjetivo;
    }

    public Integer getRutinasCompletadas() {
        return rutinasCompletadas;
    }

    public void setRutinasCompletadas(Integer rutinasCompletadas) {
        this.rutinasCompletadas = rutinasCompletadas;
    }

    public int getEntrenamientosPorSemana() {
        return entrenamientosPorSemana;
    }

    public void setEntrenamientosPorSemana(int entrenamientosPorSemana) {
        this.entrenamientosPorSemana = entrenamientosPorSemana;
    }

    public List<Medicion> getMediciones() {
        return mediciones;
    }

    public void setMediciones(List<Medicion> mediciones) {
        this.mediciones = mediciones;
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

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
}
