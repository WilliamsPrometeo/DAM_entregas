package proyecto_04.models;

import java.time.LocalDate;

/**
 * Clase que representa un ave en el zoológico.
 * Hereda de {@link Animal} y añade el atributo específico de envergadura.
 * Autor: A4Alumno05 - Pedregosa
 * Versión: 1.0
 */
public class Ave extends Animal {

    private static final long serialVersionUID = 3L;

    /** Envergadura del ave en las unidades usadas por la aplicación */
    private double envergadura;
    /** Indica si el ave puede volar */
    private boolean volador;

    /**
     * Constructor de Ave.
     * @param id identificador único
     * @param nombre nombre del ave
     * @param fechaRegistro fecha de registro
     * @param envergadura envergadura (double)
     */
    public Ave(String id, String nombre, LocalDate fechaRegistro, double envergadura, boolean volador) {
        super(id, nombre, fechaRegistro, volador);
        this.envergadura = envergadura;
        this.volador = volador;
    }

    /**
     * Devuelve la envergadura del ave.
     * @return envergadura
     */
    public double getEnvergadura() {
        return envergadura;
    }

    /**
     * Indica si el ave puede volar.
     * @return true si es voladora
     */
    public boolean isVolador() {
        return volador;
    }

    /**
     * Tipo concreto del animal.
     * @return "Ave"
     */
    @Override
    public String getTipo() {
        return "Ave";
    }

    /**
     * Representación en texto con los datos del ave.
     * @return cadena formateada con nombre, id, fecha y envergadura
     */
    @Override
    public String toString() {
        return String.format("Ave de Nombre: %s - ID: %s - Fecha de Registro: %s - Envergadura: %s - Volador: %s", getNombre(), getId(),  getFechaRegistro(),  getEnvergadura(), isVolador());
    }
}
