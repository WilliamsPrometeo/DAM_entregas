package zoo.controller;

import zoo.dao.ZooDAO;
import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.Ave;
import zoo.models.Mamifero;
import zoo.models.Pez;
import zoo.models.enums.TipoHabitat;
import zoo.recursos.MyLogger;
import zoo.recursos.MyScanner;
import zoo.recursos.Utilidades;
import zoo.service.ZooService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {

    private static final MyScanner sc = new MyScanner();

    private final ZooService service = new ZooService();

    public void addAnimal() {
        MyLogger.logInfo(ZooController.class.getSimpleName(),"Agregando animal");
        boolean correcto;
        String id = "";
        do {
            correcto = true;
            id = getId();
            try {
                service.animalValido(id);
            } catch (InvalidAnimalException ex) {
                MyLogger.logError(ZooController.class.getSimpleName(),
                        "Error en el id ",
                        ex);
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
                MyLogger.logError(ZooController.class.getSimpleName(),
                        "Error en la fecha",
                        ex);
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué tipo de animal quieres añadir?: " +
                    "\n1. Ave" +
                    "\n2. Mamifero" +
                    "\n3. Pez" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addAnimal(new Ave(id, fechaRegistro, getPlumas()), Utilidades.pedirEnum(TipoHabitat.class, "Introduce el tipo de habitat"));
                    break;
                case 2:
                    service.addAnimal(new Mamifero(id, fechaRegistro, getPatas()), Utilidades.pedirEnum(TipoHabitat.class, "Introduce el tipo de habitat"));
                    break;
                case 3:
                    service.addAnimal(new Pez(id, fechaRegistro, getEscamas()), Utilidades.pedirEnum(TipoHabitat.class, "Introduce el tipo de habitat"));
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
        MyLogger.logInfo(ZooController.class.getSimpleName(),"Animal agregado correctamente");
    }

    public void listarAnimales() {
        MyLogger.logInfo(ZooController.class.getSimpleName(),"Listando animales");
        Utilidades.imprimirMap(service.getAnimales());
    }

    public void getAnimal() {
        String id = getId();

        Animal animal = service.getAnimal(id);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    public void eliminarAnimal() {
        MyLogger.logInfo(ZooController.class.getSimpleName(),"Eliminando animal");
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

    private int getPlumas() {
        boolean correcto;
        int numPlumas;
        do {
            correcto = true;
            numPlumas = sc.pedirNumero("Introduzca el numero de plumas: ");
            if (numPlumas <= 0) {
                System.out.println("El numero de plumas no puede ser negativo");
                correcto = false;
            }
        } while (!correcto);
        return numPlumas;
    }

    private int getPatas() {
        boolean correcto;
        int numPatas;
        do {
            correcto = true;
            numPatas = sc.pedirNumero("Introduzca el numero de patas: ");
            if (numPatas < 0) {
                System.out.println("El numero de patas no puede ser negativo");
                correcto = false;
            }
        } while (!correcto);
        return numPatas;
    }

    private int getEscamas () {
        boolean correcto;
        int numEscamas;
        do {
            correcto = true;
            numEscamas = sc.pedirNumero("Introduzca el numero de escamas: ");
            if (numEscamas < 0) {
                System.out.println("El numero de escamas no puede ser negativo");
                correcto = false;
            }
        } while (!correcto);
        return numEscamas;
    }

    private String getId() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String id;
        do {
            id = sc.pideTexto("Introduce el código de reserva (3 letras y 2 números): ").toUpperCase();
        } while (!id.matches(regex));
        return id;
    }
}
