package programacion.simulacros_Proyectos.segundaEval.proyecto_04.controller;

import programacion.simulacros_Proyectos.segundaEval.proyecto_04.exceptions.InvalidAnimalException;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.exceptions.InvalidDateException;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.models.Animal;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.models.Ave;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.models.Mamifero;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.models.enums.Habitat;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.service.ZooService;
import recursos.MyScanner;
import recursos.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {

    private static final MyScanner sc =  new MyScanner();
    private final ZooService service = new ZooService();

    public void addAnimal() {
        boolean correcto;
        String idAnimal = "";
        do {
            correcto = true;
            idAnimal = getId();
            try {
                service.animalValido(idAnimal);
            } catch (InvalidAnimalException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fechaRegistro = null;
        do {
            correcto = true;
            try {
                String entrada = sc.pideTexto("Introduce la fecha de registro (yyyy-MM-dd): ");
                fechaRegistro = LocalDate.parse(entrada);
                service.fechaValida(fechaRegistro);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Que animal quieres registrar?: " +
                    "\n1. Ave" +
                    "\n2. Mamifero" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addAnimal(new Ave(idAnimal, fechaRegistro, puedeVolar()),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitat: "));
                    break;
                case 2:
                    service.addAnimal(new Mamifero(idAnimal, fechaRegistro, 4),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitat: "));
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    public void listarAnimales() {
        if (service.getUbicaciones().isEmpty()) {
            System.out.println("No hay animales que mostrar");
        } else {
            Utilidades.imprimirMap(service.getUbicaciones());
        }
    }

    public void getAnimal() {
        String id = getId();

        Animal animal = service.getAnimal(id);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrado");
        }
    }


    public void eliminarAnimal() {
        String id = getId();
        if (service.eliminarAnimal(id)) {
            System.out.println("Animal eliminado correctamente");
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    public void guardar() {
        boolean correcto;
        char opcion;
        do {
            correcto = true;
            opcion = sc.pedirLetra("¿Desea guardar? (S/N): ");
            switch (opcion) {
                case 'S':
                case 's':
                    System.out.println("Guardando datos...");
                    service.guardar();
                    break;
                case 'N':
                case 'n':
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    public void cargar() {
        boolean correcto;
        char opcion;
        do {
            correcto = true;
            opcion = sc.pedirLetra("¿Desea cargar? (S/N): ");
            switch (opcion) {
                case 'S':
                case 's':
                    System.out.println("Cargando datos...");
                    service.cargar();
                    break;
                case 'N':
                case 'n':
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    private boolean puedeVolar() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿El animal puede volar? (S/N): ");
            switch (opcion) {
                case 'S':
                case 's':
                    salida = true;
                    break;
                case 'N':
                case 'n':
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
        return salida;
    }

    private String getId() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String id;
        do {
            id = sc.pideTexto("Introduce el codigo del animal  (3 letras y 2 numeros): ").toUpperCase();
        } while (!id.matches(regex));
        return id;
    }
}
