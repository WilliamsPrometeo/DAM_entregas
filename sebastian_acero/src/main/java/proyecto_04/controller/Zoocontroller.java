package proyecto_04.controller;

import SegundoTrimestre.recursos.MyScanner;
import SegundoTrimestre.recursos.Utilidades;
import proyecto_04.exception.InvalidDateException;
import proyecto_04.models.Animal;
import proyecto_04.models.Ave;
import proyecto_04.models.Mamifero;
import proyecto_04.models.enums.Habitad;
import proyecto_04.service.ZooService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Zoocontroller {
    private static final MyScanner sc = new MyScanner();

    private final ZooService zoo = new ZooService();

    public void addAnimal() {
        boolean correcto;
        String id = "";
        do {
            correcto = true;
            id = getidAnimal();
             try {
                 zoo.getAnimal(getidAnimal());
             } catch (Exception e) {
                 System.out.println(e.getMessage());
                 correcto = false;
             }
        } while (!correcto);

        LocalDate fecharegistro = LocalDate.now();
        do {
            correcto = true;
            try {
                String fechaRegistro = sc.pideTexto("Introduce la fecha de registro (yyyy/MM/dd): ");
                fecharegistro = LocalDate.parse(fechaRegistro);
                zoo.fechaValida(fecharegistro);
            } catch (DateTimeParseException | InvalidDateException ex){
                System.out.println("ERROR: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("Introduce una opcion: " +
                    "\n.1 Ave" +
                    "\n2. Mamifero" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    zoo.addAnimal(new Ave(id, fecharegistro, patas()),
                    Utilidades.pedirEnum(Habitad.class, "Introduce el habitad: "));
                    break;
                case 2:
                    zoo.addAnimal(new Mamifero(id, fecharegistro, patas()),
                            Utilidades.pedirEnum(Habitad.class, "Introduce el habitad: "));
                break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    public void ListarAnimal() {
        Utilidades.imprimirMap(zoo.getAnimals());
    }

    public void getAnimal() {
        String id = getidAnimal();

        Animal animal = zoo.getAnimal(id);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no existe");
        }
    }

    public void eliminarAnimal() {
        String id = getidAnimal();
        if (zoo.eliminarAnimal(id)) {
            System.out.println("Animal eliminado");
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    public void guardar(){
        boolean correcto;
        char opcion;
        do {
            correcto = true;
            opcion = sc.pedirLetra("¿Desea guardar? (S/N): ");
            switch (opcion) {
                case 'S':
                case 's':
                    System.out.println("Guardando datos ...");
                    zoo.guardar();
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
                    zoo.cargar();
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

    private boolean patas() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿Quieres incluir patas? (S/N): ");
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
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el código de reserva (2 letras y 4 números): ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
        }
    }

