package proyectos_gordos.zoo.controller;

import proyectos_gordos.recursos.MyScanner;
import proyectos_gordos.recursos.Utilidades;
import proyectos_gordos.zoo.exceptions.InvalidAnimalException;
import proyectos_gordos.zoo.exceptions.InvalidDateException;
import proyectos_gordos.zoo.models.Animal;
import proyectos_gordos.zoo.models.Ave;
import proyectos_gordos.zoo.models.Mamifero;
import proyectos_gordos.zoo.models.enums.Habitat;
import proyectos_gordos.zoo.service.ZooService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {
    private static final MyScanner sc = new MyScanner();

    private final ZooService service = new ZooService();

    public void addAnimal(){
        boolean correcto;
        String id = "";
        do {
            correcto = true;
            id = getId();
            try {
                service.existeAnimal(id);
            } catch (InvalidAnimalException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fechaEntrada = null;
        do {
            correcto = true;
            try {
                String entrada = sc.pideTexto("Introduce la fecha de entrada (yyyy-MM-dd): ");
                fechaEntrada = LocalDate.parse(entrada);
                service.fechaValida(fechaEntrada);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué tipo de animal quieres registrar?: " +
                    "\n1. Registrar Mamífero" +
                    "\n2. Registrar Ave" +
                    "\nOpción: ");
            switch (opcion) {
                case 1: {

                    String nombre = sc.pideTexto("Introduce nombre del mamífero: ");
                    String especie = sc.pideTexto("Introduce especie: ");
                    String raza = sc.pideTexto("Introduce raza: ");
                    int patas = sc.pedirNumero("Introduce número de patas: ");
                    String color = sc.pideTexto("Introduce color del pelaje: ");

                    service.addAnimal(new Mamifero(id, nombre, especie, raza, fechaEntrada, patas, color),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitación: "));
                    break;
                }
                case 2: {
                    String nombre = sc.pideTexto("Introduce nombre del ave: ");
                    String especie = sc.pideTexto("Introduce especie: ");
                    String raza = sc.pideTexto("Introduce raza: ");
                    int longitud = sc.pedirNumero("Introduce longitud de alas (cm): ");
                    char letra = sc.pedirLetra("¿Es un ave rapaz? (S/N): ");
                    boolean rapaz = Character.toUpperCase(letra) == 'S';

                    service.addAnimal(new Ave(id, nombre, especie, raza, fechaEntrada, longitud, rapaz),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de habitat: "));
                    break;
                }
                default:
                    System.out.println("Opción no válida");
                    correcto = false;
                    break;
            }
        } while (!correcto);

    }

    public void listarAnimal(){
        var animales = service.getAnimal();
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados");
        } else {
            Utilidades.imprimirMap(animales);
        }
    }

    public void getAnimals(){
        String codigo =getId();
        Animal animal = service.getAnimal(codigo);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrada");
        }
    }

    public void eliminarAnimal() {
        String codigo = getId();
        if (service.eliminarAnimal(codigo)) {
            System.out.println("Animal eliminado correctamente ️ ☠🔫");
        } else {
            System.out.println("Animal no encontrada");
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
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el id del animal  (3 letras y 2 números): ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
    }
}
