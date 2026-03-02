package zoo.controller;

import recursos.MyScanner;
import recursos.Utilidades;
import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.Ave;
import zoo.models.Mamifero;
import zoo.models.enums.Habitat;
import zoo.service.ZooService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {
    private static final MyScanner sc = new MyScanner();

    private final ZooService service = new ZooService();

    public void addAnimal() {
        boolean correcto;
        String id = "";
        do {
            correcto = true;
            id = getIdAnimal();
            try {
                service.animalValidado(id);
            } catch (InvalidAnimalException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fecha_registro = null;

        do {
            correcto = true;
            try {
                String entrada = sc.pideTexto("Introduce la fecha de registro (yyyy-MM-dd): ");
                fecha_registro = LocalDate.parse(entrada);
                service.fechaValida(fecha_registro);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué tipo de animal quieres registrar?: " +
                    "\n1. Mamifero" +
                    "\n2. Ave" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addAnimal(new Mamifero(id, fecha_registro, esBipedo()),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitat: "));
                    break;
                case 2:
                    service.addAnimal(new Ave(id, fecha_registro, 2),
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
        Utilidades.imprimirMap(service.getAnimal());
    }
    public void getAnimal() {
        String idAnimal = getIdAnimal();

        Animal animal = service.getAnimal(idAnimal);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrado");
        }
    }
    public void eliminarAnimal() {
        String idAnimal = getIdAnimal();
        if (service.eliminarAnimal(idAnimal)) {
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
    private boolean esBipedo() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿Se trata de un animal Bipedo? (S/N): ");
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
    private String getIdAnimal() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String id;
        do {
            id = sc.pideTexto("Introduce el id del animal (2 letras y 4 números): ").toUpperCase();
        } while (!id.matches(regex));
        return id;
    }
}
