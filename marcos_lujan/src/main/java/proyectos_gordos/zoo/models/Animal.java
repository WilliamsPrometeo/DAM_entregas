package proyectos_gordos.zoo.models;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nombre;
    private String especie;
    private String raza;
    private LocalDate fechaEntrada;


    public Animal(String id, String nombre, String especie, String raza, LocalDate fechaEntrada) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.fechaEntrada = fechaEntrada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @Override
    public int hashCode() {return id != null ? id.hashCode() : 0;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() !=obj.getClass()) return false;

        Animal reserva = (Animal) obj;
        return this.id != null ? this.id.equals(reserva.id) : reserva.id == null;
    }

    public abstract String getTipoAnimal();
}
