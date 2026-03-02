package proyecto4.controller;

import proyecto4.exceptions.InvalidAnimalException;
import proyecto4.models.Animal;
import proyecto4.models.Ave;
import proyecto4.models.Mamifero;
import proyecto4.models.enums.Habitat;
import proyecto4.service.ZooService;
import proyecto4.recursos.MyScanner;
import proyecto4.recursos.Utilidades;
import proyecto4.exceptions.InvalidDateException;

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
            idAnimal = getCodigo();
            try {
                service.reservaValida(idAnimal);
            } catch (InvalidAnimalException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fechaRegistro = null;
        do {
            correcto = true;
            try {
                String fechaReg = sc.pideTexto("Introduzca su fecha de registro (yyyy-mm-dd): ");
                fechaRegistro = LocalDate.parse(fechaReg);
                service.fechaValida(fechaRegistro);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: Formato de entrada no valido. " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Que animal desea registrar? " +
                    "\n1. Mamífero" +
                    "\n2. Ave" +
                    "\nOpción: ");

            switch (opcion) {
                case 1:
                    service.addAnimal(new Ave(idAnimal, fechaRegistro, incluyeShow()),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de Habitat"));
                    break;
                case 2:
                    service.addAnimal(new Mamifero(idAnimal, fechaRegistro, 4),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitat"));
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    public void listarReservas() {
        Utilidades.imprimirMap(service.getAnimals());
    }

    public void getAnimal() {
        String codigo = getCodigo();
        Animal animal = service.getAnimals(codigo);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    public void eliminarAnimal() {
        String codigo = getCodigo();
        if (service.eliminarReserva(codigo)) {
            System.out.println("Animal eliminado");
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
                    System.out.println("Y YO ME LLAMO MERCEDES!!!!!!!!!");
                    break;
                default:
                    System.out.println("Opcion no valida.");
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
                    System.out.println("Y YO ME LLAMO MERCEDES!!!!!!!!!");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    private boolean incluyeShow() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿Quieres incluir el show? (S/N): ");
            switch (opcion) {
                case 'S':
                case 's':
                    salida = true;
                    break;
                case 'N':
                case 'n':
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    correcto = false;
                    break;
            }
        } while (!correcto);
        return salida;
    }

    private String getCodigo() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String idAnimal;
        do {
            idAnimal = sc.pideTexto("Introduzca su código de identificacion de animal (ABC12): ").toUpperCase();
        } while (!idAnimal.matches(regex));
        return idAnimal;
    }
}
