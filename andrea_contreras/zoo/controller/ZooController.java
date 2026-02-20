package proyecto04.zoo.controller;

import proyecto04.zoo.exceptions.InvalidAnimalException;
import proyecto04.zoo.exceptions.InvalidDateException;
import proyecto04.zoo.models.Animal;
import proyecto04.zoo.models.Ave;
import proyecto04.zoo.models.Mamifero;
import proyecto04.zoo.models.enums.Habitat;
import proyecto04.zoo.service.ZooService;
import recursos.MyScanner;
import recursos.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {
    private static final MyScanner sc = new MyScanner();

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

        LocalDate fecharegistro = null;
        do {
            correcto = true;
            try {
                String registro = sc.pideTexto("Introduce la fecha de registro (yyyy-MM-dd): ");
                fecharegistro = LocalDate.parse(registro);
                service.registroValido(fecharegistro);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué animal quieres visitar?: " +
                    "\n1. Mamifero" +
                    "\n2. Ave" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addAnimal(new Mamifero(idAnimal, fecharegistro, sc.pedirNumero("Introduce numero de patas: ")),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitat: "));
                    break;
                case 2:
                    service.addAnimal(new Ave(idAnimal, fecharegistro, sc.pideTexto("Introduce el tipo de comida: ")),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitat: "));
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    public void listarAnimal() {

        Utilidades.imprimirMap(service.getAnimal());
    }

    public void getAnimal() {
        String id = getId();

        Animal reserva = service.getAnimal(id);
        if (reserva != null) {
            System.out.println(reserva);
        } else {
            System.out.println("Reserva no encontrada");
        }
    }

    public void eliminarAnimal() {
        String codigo = getId();
        if (service.eliminarAnimal(codigo)) {
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
                    System.out.println("Guardando datos ...");
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
                    System.out.println("Cargando datos ...");
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

    private String getId() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String id;
        do {
            id = sc.pideTexto("Introduce el ID deL animal(3 letras y 2 números): ").toUpperCase();
        } while (!id.matches(regex));
        return id;
    }
}
