package proyecto2.clases;

public class Servicio {

    /**
     * @autor David Muñoz @version clase servicios @parameters: String descripcion,String mecanico, TipoServicio tipo,
     * los strings muestran las descripciones/especificaciones, El mecánico y los tipos de servicio.
     *
     */
    public Servicio() {
        MyScanner sc = new MyScanner();

    }

    public static void registrarservicio() {
        System.out.println("Mantenimiento");
        System.out.println("Cambio de Aceite");
        System.out.println("Pintura");
        System.out.println("Frenos");
        System.out.println("Electricidad");




    }
}
