package zoo.controller;


import recursos.MyScanner;
import recursos.Utilidades;
import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.Ave;
import zoo.models.Mamifero;
import zoo.models.enums.Habitat;
import zoo.service.AnimalService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AnimalController {
    private static final MyScanner sc = new MyScanner();

    private final AnimalService service = new AnimalService();

    public void addAnimal() {
        boolean correcto;
        String numCodigo = "";
        do {
            correcto = true;
            numCodigo = getCodigo();
            try {
                service.animalValido(numCodigo);
            } catch (InvalidAnimalException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fecharegistro = null;
        do {
            correcto = true;
            try {
                String inicio = sc.pideTexto("Introduce la fecha de registro (yyyy-MM-dd): ");
                fecharegistro = LocalDate.parse(inicio);
                service.fechaValida(fecharegistro);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué tipo de animal es?: " +
                    "\n1. Mamífero" +
                    "\n2. Ave" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addAnimal(new Mamifero(fecharegistro, numCodigo, reproduccion()),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el habitat: "));
                    break;
                case 2:
                    service.addAnimal(new Ave(numCodigo, fecharegistro, anda ()),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el habitat: "));
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);

    }

    public void listarAnimal() {
        Utilidades.imprimirMap(service.ubicaciones());
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

    private boolean anda() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿Anda o Salta? (A/S): ");
            switch (opcion) {
                case 'A':
                case 'a':
                    salida = true;
                    break;
                case 'S':
                case 's':
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
        return salida;
    }


    private boolean reproduccion() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿Está en epoca de reproduccioón? (S/N): ");
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
            codigo = sc.pideTexto("Introduce el código de animal (3 letras y 2 números): ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
    }
}
