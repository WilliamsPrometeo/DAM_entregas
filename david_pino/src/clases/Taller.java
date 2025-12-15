package clases;
/**
 * Clase Taller
 * Autor: David Pino
 * Version 1.0
 */


/* Importamos todo lo que vamos a usar */


import enums.TipoVehiculo;
import exceptions.VehiculoNoEncontrado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


/*Inicializamos taller con las listas de vehiculos y servicios, además de un map*/

public class Taller {
    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
    }

    //getters and setters
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }

    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }

    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }

    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    public void registrarVehiculo() {           /*Metodo de registrarVehiculo*/
        Vehiculo coche = new Vehiculo("Modelo", "Matricula", null);
        coche.setModelo(sc.pedirSoloTexto("Introduce el modelo: ")); /*Llamas al setter del modelo*/
        String matricula;
        TipoVehiculo tipo = null; //Tipo nulo para iniciar
        do {
            matricula = sc.pedirSoloTexto("Introduce el matricula: ");
            String mensaje = matricula.length() == 7 ? "La matricula es correcta" : "Error, asegurese de que la matricula tiene 7 caracteres"; /*Para que solo acepte matriculas*/
            System.out.println(mensaje);
        } while (matricula.length() != 7);
        boolean correcto = true; /* El boolean de siempre para hacer un menú*/
        do {
            correcto = true;
            int opcion_TV = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camion" +
                    "\nIntroduce el tipo de vehiculo");
            switch (opcion_TV) {
                case 1:
                    tipo = TipoVehiculo.TURISMO;
                    break;
                case 2:
                    tipo = TipoVehiculo.MOTOCICLETA;
                    break;
                case 3:
                    tipo = TipoVehiculo.FURGONETA;
                    break;
                case 4:
                    tipo = TipoVehiculo.CAMION;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);        /*Para que solo metas valores posibles*/
        vehiculos.add((Vehiculo) coche);   // Se añaden a la lista de vehiculos
        vehiculos.add(new Vehiculo(Vehiculo.getModelo(), matricula, tipo));
    }
    public String registrarServicio() {         // Método por el cual vamos a registrar el tipo de servicio mediante un "menu"
        String descripcion = sc.pedirSoloTexto("Introduce la descripcion del servicio: ");
        String mecanico = sc.pedirSoloTexto("Introduce al mecanico del servicio: ");
        enums.TipoServicio TipoServicio = null;
        boolean correcto = true; //boolean otra vez
        do {
            correcto = true;
            int opcion_servicio = sc.pedirNumero("1. Mantenimiento" +
                    "\n2. Cambio de Aceite" +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\n5. Electricidad" +
                    "\nIntroduce el tipo de servicio");
            switch (opcion_servicio) {      //boolean otra vezzz
                case 1:
                    TipoServicio = enums.TipoServicio.MANTENIMIENTO;
                    break;
                case 2:
                    TipoServicio = enums.TipoServicio.CAMBIO_ACEITE;
                    break;
                case 3:
                    TipoServicio = enums.TipoServicio.PINTURA;
                    break;
                case 4:
                    TipoServicio = enums.TipoServicio.FRENOS;
                    break;
                case 5:
                    TipoServicio = enums.TipoServicio.ELECTRICIDAD;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        catalogoServicios.add(new Servicio(descripcion, mecanico, TipoServicio));       //Se añaden al catalogo
        return descripcion;
    }
    public String asignarServicio() throws exceptions.VehiculoNoEncontrado {        // Se inicializa el método asignarServicio por el cual
        String matricula = sc.pideTexto("Introduce la matricula: ");        // Solicita la matrícula
        Vehiculo vehiculo = buscarVehiculo(matricula);                              // Llama a buscarVehiculo
        try {
            vehiculo = buscarVehiculo(matricula);

        } catch (exceptions.VehiculoNoEncontrado e) {       //Lanza Vehiculo no encontrado si no lo encuentra
            System.out.println(e.getMessage());
            vehiculo = null;
        }
        Servicio servicio = null;
        if (vehiculo != null) {
            mostrarTrabajos();
            String descripcion = sc.pideTexto("Introduce la descripcion del servicio: ");
            servicio = buscarServicio(descripcion);         //Busca servicio en catálogo
            if (vehiculo != null) {
                catalogoServicios.remove(servicio);
                trabajosRealizados.put(vehiculo, servicio);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fecha_formateada = LocalDateTime.now().format(formatter);
                System.out.printf("Fecha: %s del servicio: %s", fecha_formateada, servicio.getDescripcion());       //Muestro fecha y hora con LocalDateTime
            } else  {
                System.out.println("No existe el servicio");
            }
        } else  {
            System.out.println("No existe el coche con esa matricula");
        }
        return (vehiculo != null && servicio != null) ? "Servicio realizado" : "Error en el servicio";
    }


    public void filtrarTipoVehiculo(){
        TipoVehiculo TipoVehiculo = null;
        boolean correcto = true;
        do {
            correcto = true;
            int opcion_TV = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camion" +
                    "\n Introduce la opcion que desees");
            switch (opcion_TV) {
                case 1:
                    TipoVehiculo = enums.TipoVehiculo.TURISMO;
                    break;
                case 2:
                    TipoVehiculo = enums.TipoVehiculo.MOTOCICLETA;
                    break;
                case 3:
                    TipoVehiculo = enums.TipoVehiculo.FURGONETA;
                    break;
                case 4:
                    TipoVehiculo = enums.TipoVehiculo.CAMION;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!correcto);
        for (Vehiculo vehiculo : vehiculos) {
            if (TipoVehiculo == vehiculo.getTipoVehiculo()) {
                System.out.println(vehiculo);
            }
        }
    }

    public Servicio buscarServicio(String descripcion) {
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getDescripcion().equals(descripcion)) {
                return servicio;
            }
        }
        return null;
    }

    public void mostrarVehiculos() {        //Inicializo mostrarVehiculos para que me de una lista con estos
        boolean correcto;
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            do {
                //filtro
                char opcion = sc.pedirLetra("¿Quieres filtrar por tipo? s/n");
                switch (opcion) {
                    case 's':
                    case 'S':
                        correcto = true;
                        break;
                    case 'n':
                    case 'N':
                        correcto = true;        //te pregunta si quieres filtro
                        break;
                    default:
                        correcto = false;
                        break;
                }
            } while (!correcto) ;
        } else {
            System.out.println("No hay vehiculos disponibles");     //Cuando no hay vehiculos
        }
    }

    public void mostrarTrabajos() {         //Inicializo mostrarTrabajos que nos va a printear los trabajos asignados
        for (Vehiculo vehiculo: trabajosRealizados.keySet()) {
            System.out.printf("Trabajos Realizados: Vehiculo: %s, Servicio: %s", vehiculo.getModelo(), trabajosRealizados.get(vehiculo));
        }
    }

    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {      //Inicializo buscarVehiculo que busca los vehiculos asignados
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        return null;
    }
}
