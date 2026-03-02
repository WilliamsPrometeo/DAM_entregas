package zoologico.controller;

import ejercicioEvaluable.mvc.exception.InvalidAnimalException;
import ejercicioEvaluable.mvc.exception.InvalidDateException;
import ejercicioEvaluable.mvc.models.Animal;
import ejercicioEvaluable.mvc.models.Ave;
import ejercicioEvaluable.mvc.models.Mamifero;
import ejercicioEvaluable.mvc.models.enums.Habitat;
import ejercicioEvaluable.mvc.service.ZooService;
import recursos.MyScanner;
import recursos.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {
    private static final MyScanner sc = new MyScanner();
    private final ZooService zooService = new ZooService();

    public void agregarAnimal() {
        String idAnimal = "";
        boolean correcto;

        do {
            correcto = true;
            idAnimal = obtenerId();

            try {
                zooService.animalValido(idAnimal);
            } catch (InvalidAnimalException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fecha = null;

        do {
            correcto = true;
            try {
                String registro = sc.pideTexto("Dime la fecha de registro (yyyy-MM-dd): ");
                fecha = LocalDate.parse(registro);
                zooService.fechaValida(fecha);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué tipo de animal quieres registrar?: \n" +
                    "1. Ave\n" +
                    "2. Mamifero\n" +
                    "Opcion: ");
            switch (opcion) {
                case 1:
                    zooService.addAnimal(new Ave(idAnimal, fecha, puedeVolar()), Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitat: "));
                    break;
                case 2:
                    zooService.addAnimal(new Mamifero(idAnimal, fecha,  4), Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitat: "));
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
            char opcion = sc.pedirLetra("¿Puede volar? (S/N): ");
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

    public void listarAnimales() {
        Utilidades.imprimirMap(zooService.getAnimales());
    }

    public void buscarAnimal() {
        String idAnimal = obtenerId();
        Animal animal = zooService.getAnimal(idAnimal);

        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    public void elimarAnimal() {
        String idAnimal = obtenerId();
        if (zooService.eliminarAnimal(idAnimal)) {
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
            opcion = sc.pedirLetra("Desea guardar? (S/N): ");
            switch (opcion) {
                case 'S':
                case 's':
                    System.out.println("Guardando datos...");
                    zooService.guardar();
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
            opcion = sc.pedirLetra("Desea cargar? (S/N): ");
            switch (opcion) {
                case 'S':
                case 's':
                    System.out.println("Cargando datos...");
                    zooService.cargar();
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

    private String obtenerId() {
        String regrex = "^[A-Z]{2}[0-9]{4}$";
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el codigo del animal(AB1234): ").toUpperCase();
        } while (!codigo.matches(regrex));
        return codigo;
    }
}
