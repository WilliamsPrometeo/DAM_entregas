package simulacro2; // Define el paquete donde se encuentra la clase

/**
 * Clase abstracta que representa a una persona dentro del sistema.
 * Sirve como base para otras clases como Usuario.
 * Contiene atributos comunes como nombre y DNI.
 *
 * @author Tu Nombre
 * @version 1.0
 */
public abstract class Persona {

    /** Nombre de la persona */
    private String nombre;

    /** DNI de la persona (debe tener 9 caracteres) */
    private String dni;

    /**
     * Constructor vacío por defecto.
     * Permite crear objetos sin inicializar sus atributos de inmediato.
     */
    public Persona() {
    }

    /**
     * Constructor que permite inicializar todos los atributos de la clase.
     *
     * @param nombre nombre de la persona
     * @param dni DNI de la persona
     */
    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre nuevo nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el DNI de la persona.
     *
     * @return DNI de la persona
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI de la persona.
     *
     * @param dni nuevo DNI a asignar
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
}
