package proyecto_04.controller;

import Proyecto_01.Scanner.MyScanner;
import proyecto_03.utilidades.Utilidades;
import proyecto_04.exceptions.InvalidAnimalException;
import proyecto_04.exceptions.InvalidDateException;
import proyecto_04.models.Animal;
import proyecto_04.models.Ave;
import proyecto_04.models.Mamifero;
import proyecto_04.models.enums.Habitat;
import proyecto_04.service.ZooService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {
    private static final MyScanner sc = new MyScanner();
    private final ZooService service = new ZooService();

    public void addAnimal() {
        String id = "";
        boolean correcto;

        do {
            correcto = true;
            id = getID();
            try {
                service.idValido(id);
            } catch (InvalidAnimalException ex) {
                System.out.println("ERROR: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        String nombre = sc.pideTexto("Introduce nombre: ");
        LocalDate fechaRegistro = null;

        do {
            correcto = true;
            try {
                String registro = sc.pideTexto("Introduce la fecha de registro (yyyy-mm-dd): ");
                fechaRegistro = LocalDate.parse(registro);
                service.fechaValida(fechaRegistro);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("ERROR: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            Animal animal = null;
            int opc = sc.pedirNumero("Tipo de animal: " +
                    "\n1. Mamifero" +
                    "\n2. Ave" +
                    "\nElige:");
            switch (opc) {
                case 1:
                    String color = sc.pideTexto("Color de pelaje: ");
                    int patas = sc.pedirNumero("Numero de patas: ");
                    char volarM = sc.pedirLetra("¿Es volador? (S/N): ");
                    boolean voladorM = (volarM == 'S' || volarM == 's');
                    animal = new Mamifero(id, nombre, fechaRegistro, color, patas, voladorM);
                    break;
                case 2:
                    double env = sc.pedirDecimal("Envergadura (metros, ej: 1.5): ");
                    char volarA = sc.pedirLetra("¿Es volador? (S/N): ");
                    boolean voladorA = (volarA == 'S' || volarA == 's');
                    animal = new Ave(id, nombre, fechaRegistro, env, voladorA);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }

            if (animal != null) {
                Habitat habitat = pedirHabitat();
                service.addAnimal(animal, habitat);
                System.out.println("Animal registrado correctamente.");
            }
        } while (!correcto);
    }

    public void listarAnimales() {
        if (service.getUbicaciones().isEmpty()) {
            System.out.println("no se han encontrado animales registrados");
        } else {
            Utilidades.imprimirMap(service.getUbicaciones());
        }
    }

    public void getAnimal() {
        String id = getID();

        Animal a = service.getAnimal(id);
        if (a != null) {
            System.out.println(a + ", habitat=" + service.getUbicaciones().get(a));
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    public void eliminarAnimal() {
        String id = getID();

        if (service.eliminarAnimal(id)) {
            System.out.println("Animal eliminado");
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    public void guardar() {
        boolean correcto;
        char opc;

        do {
            correcto = true;
            opc = sc.pedirLetra("Desea guardar? (S/N): ");
            switch (opc) {
                case 'S':
                case 's':
                    System.out.println("Guardando datos... ");
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
        char opc;

        do {
            correcto = true;
            opc = sc.pedirLetra("Desea cargar? (S/N): ");
            switch (opc) {
                case 'S':
                case 's':
                    System.out.println("Cargando datos... ");
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

    private Habitat pedirHabitat() {
        return Utilidades.pedirEnum(Habitat.class, "Introduce el habitat: ");
    }

    private String getID() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el codigo del animal (3 letras, 2 numeros): ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
    }
}
