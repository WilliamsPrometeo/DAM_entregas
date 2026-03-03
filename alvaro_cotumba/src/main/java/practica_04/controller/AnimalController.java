package practica_04.controller;

import practica_04.exceptions.InvalidAnimalException;
import practica_04.exceptions.InvalidDateException;
import practica_04.models.Amfibio;
import practica_04.models.Animal;
import practica_04.models.Reptil;
import practica_04.models.enums.Habitat;
import practica_04.service.AnimalService;
import recursos.MyScanner;
import recursos.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AnimalController {

    private static final MyScanner sc = new MyScanner();

    private final AnimalService service = new AnimalService();

    public void addAnimal() {
        boolean correcto;
        String id = "";
        do {
            correcto = true;
            id = getCodigo();
            try {
                service.animalValido(id);
            } catch (InvalidAnimalException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fechaRegistro = null;
        do {
            correcto = true;
            try {
                String registro = sc.pideTexto("Introduce la fecha de regsitro (yyyy-MM-dd): ");
                fechaRegistro = LocalDate.parse(registro);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué animal quieres ver?: " +
                    "\n1. Ver amfibio" +
                    "\n2. Ver reptil" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addAnimal(new Reptil(id, fechaRegistro, incluyeSnackparaReptil()),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitat: "));
                    break;
                case 2:
                    service.addAnimal(new Amfibio(id, fechaRegistro, 11),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitacion: "));
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);

    }

    public void listarAnimales() {
        Utilidades.imprimirMap(service.getUbicacion());
    }

    public void getAnimal() {
        String codigo = getCodigo();

        Animal animal = service.getUbicacion(codigo);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    public void eliminarAnimal() {
        String codigo = getCodigo();
        if (service.eliminarAnimal(codigo)) {
            System.out.println("Animal cancelado correctamente");
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

    private boolean incluyeSnackparaReptil() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿Quieres incluir el Snack para reptil? (S/N): ");
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

    private String getCodigo() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el código de reserva (3 letras y 2 números): ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
    }
}
