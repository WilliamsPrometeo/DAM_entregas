package gestion_zoo.controller;

import gestion_zoo.exceptions.InvalidAnimalException;
import gestion_zoo.exceptions.InvalidDateException;
import gestion_zoo.models.Animal;
import gestion_zoo.models.ZooAve;
import gestion_zoo.models.ZooMamifero;
import gestion_zoo.models.enums.TipoHabitat;
import gestion_zoo.service.ZooService;
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
            idAnimal = getidAnimal();
            try {
                service.animalValida(idAnimal);
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
                fechaRegistro = LocalDate.parse(registro);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué animal quieres registrar?: " +
                    "\n1. Animal Ave" +
                    "\n2. Animal Mamifero" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addAnimal(new ZooAve(idAnimal, fechaRegistro, colorOscuro()),
                            Utilidades.pedirEnum(TipoHabitat.class, "Introduce el tipo de habitat: "));
                    break;
                case 2:
                    service.addAnimal(new ZooMamifero(idAnimal, fechaRegistro, colorOscuro()),
                            Utilidades.pedirEnum(TipoHabitat.class, "Introduce el tipo de habitat: "));
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

    public void getReserva() {
        String idAnimal = getidAnimal();

        Animal animal = service.getAnimal(idAnimal);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    public void eliminarReserva() {
        String codigo = getidAnimal();
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

    private boolean colorOscuro() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿El animal es oscuro? (S/N): ");
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

    private String getidAnimal() {
        String regex = "^[A-Z]{2}[0-9]{4}$";
        String idAnimal;
        do {
            idAnimal = sc.pideTexto("Introduce la identificacin del animal (2 letras y 4 números): ").toUpperCase();
        } while (!idAnimal.matches(regex));
        return idAnimal;
    }
}