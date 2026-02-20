package proyecto_04.controller;

import proyectos.proyecto_04.exceptions.InvalidDateException;

import proyectos.proyecto_04.exceptions.InvalidAnimalException;
import proyectos.proyecto_04.models.Animal;
import proyectos.proyecto_04.models.Ave;
import proyectos.proyecto_04.models.Mamifero;
import proyectos.proyecto_04.models.enums.TipoHabitats;
import proyectos.proyecto_04.service.AnimalService;
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
            id = getId();
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
                String registro = sc.pideTexto("Introduce la fecha de registro (yyyy-MM-dd): ");
                fechaRegistro = LocalDate.parse(registro);
                service.fechaValida(fechaRegistro);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué resserva quieres realizar?: " +
                    "\n1. Mamífero" +
                    "\n2. Ave" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addAnimal(new Mamifero(id, fechaRegistro, getCarnivoro(), getHervivoro()),
                            Utilidades.pedirEnum(TipoHabitats .class, "Introduce el tipo de habitat: "));
                    break;
                case 2:
                    service.addAnimal(new Ave(id, fechaRegistro, puedeVolar()),
                            Utilidades.pedirEnum(TipoHabitats.class, "Introduce el tipo de habitat: "));
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
        String id = getId();

        Animal animal = service.getAnimal(id);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Reserva no encontrada");
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

    private boolean puedeVolar() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿Este animal puede volar? (S/N): ");
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
            id = sc.pideTexto("Introduce el ID del animal (3 letras y 2 números): ").toUpperCase();
        } while (!id.matches(regex));
        return id;
    }

    private boolean getCarnivoro() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿Este animal come carne? (S/N): ");
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

    private boolean getHervivoro() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿Este animal come plantas? (S/N): ");
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
