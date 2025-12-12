package simulacro2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * La clase Usuario representa a un usuario registrado en la librería.
 * Extiende de la clase Persona, heredando nombre y DNI.
 * Además, almacena la fecha de alta del usuario y redefine algunos métodos
 * para mostrar información más detallada.
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Usuario extends Persona {

    /** Fecha y hora en la que el usuario fue dado de alta en el sistema */
    private LocalDateTime fecha_alta;

    /**
     * Constructor por defecto.
     * Asigna automáticamente la fecha de alta al momento actual.
     */
    public Usuario() {
        fecha_alta = LocalDateTime.now(); // Guarda la fecha y hora actuales
    }

    /**
     * Constructor que inicializa el nombre y DNI del usuario,
     * además de asignar la fecha de alta.
     *
     * @param nombre nombre del usuario
     * @param dni DNI del usuario
     */
    public Usuario(String nombre, String dni) {
        super(nombre, dni); // Llama al constructor de Persona
        fecha_alta = LocalDateTime.now(); // Fecha actual al registrarlo
    }

    /**
     * Obtiene la fecha de alta del usuario.
     *
     * @return fecha de alta como objeto LocalDateTime
     */
    public LocalDateTime getFecha_alta() {
        return fecha_alta;
    }

    /**
     * Establece una nueva fecha de alta para el usuario.
     *
     * @param fecha_alta nueva fecha a asignar
     */
    public void setFecha_alta(LocalDateTime fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    /**
     * Sobrescribe el método getNombre() de Persona para devolver
     * un formato más descriptivo del usuario, incluyendo su DNI
     * y la fecha de alta formateada.
     *
     * @return texto con nombre, DNI y fecha de alta
     */
    @Override
    public String getNombre() {
        // Formateador para mostrar la fecha en formato legible
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Convierte la fecha de alta al formato indicado
        String fecha_formateada = getFecha_alta().format(formatter);

        // Devuelve un mensaje completo con los datos del usuario
        return String.format(
                "Usuario: %s, DNI: %s, Fecha de alta: %s",
                super.getNombre(), super.getDni(), fecha_formateada
        );
    }

    /**
     * Compara dos usuarios basándose en su DNI.
     * Si el DNI coincide, se considera el mismo usuario.
     *
     * @param o objeto con el que comparar
     * @return true si los DNI son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Si es el mismo objeto
        if (o == null || getClass() != o.getClass()) return false; // Si no es Usuario

        Usuario usuario = (Usuario) o;

        // Compara los DNI (usando los getters heredados)
        return super.getDni() != null ?
                super.getDni().equals(usuario.getDni()) :
                usuario.getDni() == null;
    }

    /**
     * Genera el código hash del usuario basándose únicamente en su DNI.
     *
     * @return hash calculado a partir del DNI
     */
    @Override
    public int hashCode() {
        return super.getDni() != null ? super.getDni().hashCode() : 0;
    }
}
