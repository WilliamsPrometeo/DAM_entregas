package entrega4.models;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Animal implements Serializable {

    /**
     * Clase abstracta Animal
     * @author Rodrigo Boto
     * @version 1.0
     * Se implementa el serializable en esta clase, servirá para posteriormente añadir información al resto de clases AVE y MAMIFERO
     */

    private static final long serialVersionUID = 1L;

    private String id_animal;
    private LocalDate fechaRegistro;

    public Animal(String id_animal, LocalDate fechaRegistro) {
        this.id_animal = id_animal;
        this.fechaRegistro = fechaRegistro;
    }

    public String getId_animal() {
        return id_animal;
    }

    public void setId_animal(String id_animal) {
        this.id_animal = id_animal;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public abstract String getTipoAnimal();

    /**
     * Método equals para obtener el id del animal y verificar que existe y no está repetido
     * @author Rodrigo Boto
     * @version 1.0
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return this.id_animal != null ? this.id_animal.equals(animal.id_animal) : animal.id_animal == null;
    }
}
