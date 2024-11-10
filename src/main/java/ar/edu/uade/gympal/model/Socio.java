package ar.edu.uade.gympal.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import ar.edu.uade.gympal.model.objetivo.Objetivo;
import ar.edu.uade.gympal.model.rutina.Rutina;
import ar.edu.uade.gympal.model.trofeo.Trofeo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int entrenamientosPorSemana;
    private float peso; // Asegúrate de tener este atributo para verificar el peso

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<Medicion> mediciones = new ArrayList<>();

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<Trofeo> trofeos = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "objetivo_id")
    private Objetivo objetivo;

    @OneToOne
    private Rutina rutina;

    private float masaMuscular; // Masa muscular del socio
    private float porcentajeGrasa; // Porcentaje de grasa del socio

    public Medicion ultimaMedicion() {
        return mediciones.get(mediciones.size() - 1);
    }

    // Metodo para verificar si cumplió la rutina perfectamente
    public boolean haCumplidoRutinaPerfectamente() {
        return this.rutina != null && this.rutina.esPerfecta(); // Asumiendo que la rutina tiene el método esPerfecta()
    }

    public void añadirTrofeo(Trofeo trofeo) {
        this.trofeos.add(trofeo);
    }

    // Metodo para contar los pesajes en el último mes
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

    // Metodo para generar valores ideales
  public Medicion generarMedicionIdeal() {
    Random random = new Random();
    
    float pesoIdeal = 70 + random.nextFloat() * 10;
    float masaMuscularIdeal = 30 + random.nextFloat() * 10;
    float porcentajeGrasaIdeal = 10 + random.nextFloat() * 10;
    
    // Retorna una nueva instancia de Medicion con los valores ideales
    return new Medicion(pesoIdeal, masaMuscularIdeal, porcentajeGrasaIdeal, null); 
}

    // public boolean haCumplidoObjetivo() {
    // if (this.objetivo != null) {
    // return this.objetivo.verificarCumplimiento();
    // }
    // return false;
    // }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getMasaMuscular() {
        return masaMuscular;
    }

    public void setMasaMuscular(float masaMuscular) {
        this.masaMuscular = masaMuscular;
    }

    // Metodo para obtener el porcentaje de grasa del socio
    public float getPorcentajeGrasa() {
        return porcentajeGrasa;
    }

    public void setPorcentajeGrasa(float porcentajeGrasa) {
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

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

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public int getEntrenamientosPorSemana() {
        return entrenamientosPorSemana;
    }

    public void setEntrenamientosPorSemana(int entrenamientosPorSemana) {
        this.entrenamientosPorSemana = entrenamientosPorSemana;
    }
}
