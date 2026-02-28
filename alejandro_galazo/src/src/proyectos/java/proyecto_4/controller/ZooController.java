package proyecto_4.controller;

import proyecto_4.exceptions.InvalidAnimalException;
import proyecto_4.exceptions.InvalidDateException;
import proyecto_4.models.Animal;
import proyecto_4.models.Ave;
import proyecto_4.models.Reptil;
import proyecto_4.models.enums.Habitat;
import proyecto_4.service.ZooService;
import recursos.MyScanner;
import recursos.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {

    private static final MyScanner sc = new MyScanner();

    private final ZooService service = new ZooService();

    public void addAnimal() {
        boolean correcto;
        String codigoAnimal = "";
        do {
            correcto = true;
            codigoAnimal = getCodigo();
            try {
                service.animalValido(codigoAnimal);
            } catch (InvalidAnimalException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fecha_adquisicion = null;
        do {
            correcto = true;
            try {
                String entrada = sc.pideTexto("Introduce la fecha de adquisicion (yyyy-MM-dd): ");
                fecha_adquisicion = LocalDate.parse(entrada);
                service.fechaValida(fecha_adquisicion);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué animal quieres añadir?: " +
                    "\n1. Reptil" +
                    "\n2. Ave" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addAnimal(new Reptil(codigoAnimal, fecha_adquisicion, Habitat.SELVA, esVenenoso()),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el habitat: "));
                    break;
                case 2:
                    service.addAnimal(new Ave(codigoAnimal, fecha_adquisicion, Habitat.GRANJA, 1),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el habitat: "));
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);

    }

    public void listarAnimales() {
        Utilidades.imprimirMap(service.getAnimales());
    }

    public void getAnimal() {
        String codigo = getCodigo();

        Animal animal = service.getAnimal(codigo);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    public void eliminarAnimal() {
        String codigo = getCodigo();
        if (service.eliminarAnimal(codigo)) {
            System.out.println("Animal eliminado correctamente");
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    private String getCodigo() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el código del animal (3 letras y 2 números): ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
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

    private boolean esVenenoso() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿El animal es venenoso? (S/N): ");
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

}
