package practica4.zoo.controller;

import practica4.zoo.exceptions.InvalidAnimalException;
import practica4.zoo.exceptions.InvalidDateException;
import practica4.zoo.models.Animal;
import practica4.zoo.models.Ave;
import practica4.zoo.models.Mamifero;
import practica4.zoo.models.enums.Habitat;
import practica4.zoo.service.ZooService;
import recursos.Miscanner;
import recursos.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {

    private static final Miscanner sc = new Miscanner();

    private final ZooService service = new ZooService();

    public void addAnimales() {
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

        LocalDate fechaRegistro = null;
        do {
            correcto = true;
            try {
                String registro = sc.pideTexto("Introduce la fecha de registro (yyyy-MM-dd): ");
                fechaRegistro= LocalDate.parse(registro);
                service.fechaValida(fechaRegistro);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué animal quieres registrar?: " +
                    "\n1. Mamífero" +
                    "\n2. Ave" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addAnimales(new Mamifero(codigoAnimal, fechaRegistro, sc.pedirNumero("Introduce el numero de patas: ")),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitat: "));
                    break;
                case 2:
                    service.addAnimales(new Ave(codigoAnimal, fechaRegistro, sc.pideTexto("Introduce el color de plumas: ")),
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
        Utilidades.imprimirMap(service.getAnimales());
    }

    public void getAnimal() {
        String codigo = getCodigo();

        Animal animal = service.getAnimales(codigo);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    public void eliminarAnimal() {
        String codigo = getCodigo();
        if (service.eliminarAnimal(codigo)) {
            System.out.println("Animal ejecutado correctamente, PETA estará contenta...");
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

    private String getCodigo() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el código de reserva (3 letras y 2 números): ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
    }
}
