package segunda_evaluacion.prueba4.controller;

import segunda_evaluacion.prueba4.exceptions.InvalidDateException;
import segunda_evaluacion.prueba4.models.Animal;
import segunda_evaluacion.prueba4.models.Ave;
import segunda_evaluacion.prueba4.models.Mamifero;
import segunda_evaluacion.prueba4.models.enums.Habitat;
import segunda_evaluacion.prueba4.recursos.Utilidades;
import segunda_evaluacion.prueba4.service.ZooService;
import segunda_evaluacion.recursos.MyScanner;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {

    private static final MyScanner sc = new MyScanner();

    private final ZooService zooService = new ZooService();

    public void addAnimal() {

        boolean correcto;
        String IdAnimal = "";

        do {
            correcto = true;
            IdAnimal = getId();

            try {
                zooService.animalValido(IdAnimal);
            } catch (InvalidDateException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);
        LocalDate fechaRegistro = null;

        do {
            correcto = true;
            try {
                String registro = sc.pideTexto("Introduce la fecha de registro (yyyy-mm-dd): ");
                fechaRegistro = LocalDate.parse(registro);
            } catch (DateTimeParseException ex) {
                System.out.println("Error de registro no valido" + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero2("¿Que animal quieres registrar?: " +
                    "\n1. Registrar Ave" +
                    "\n2. Registrar Mamifero" +
                    "\nOpcion:");

            switch (opcion) {

                case 1:
                    zooService.addAnimal(
                            new Ave(
                                    IdAnimal,
                                    fechaRegistro,
                                    2
                            ),
                            Utilidades.pedirEnum(Habitat.class,
                                    "Introduce el tipo de habitat")
                    );
                    break;

                case 2:
                    zooService.addAnimal(
                            new Mamifero(
                                    IdAnimal,
                                    fechaRegistro,
                                    sonTerrestres()
                            ),
                            Utilidades.pedirEnum(Habitat.class,
                                    "Introduce el tipo de habitat")
                    );
                    break;

                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    public void listarAnimales() {
        Utilidades.imprimirMap(zooService.getAnimals());
    }

    public void getAnimal(){
        String id = getId();
        Animal animal = zooService.getAnimal(id);

        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no existe");
        }
    }

    public void eliminarAnimal() {
        String id = getId();

        if (zooService.eliminarAnimal(id)) {
            System.out.println("Animal eliminado correctamente");
        } else {
            System.out.println("Animal no existe");
        }
    }

    public void guardar(){
        boolean correcto;
        char opcion;

        do {
            correcto = true;
            opcion = sc.pedirLetra("Desea guardar? (S/N):");

            switch (opcion) {
                case 'S':
                case 's':
                    System.out.println("Guardando datos...");
                    zooService.guardar();
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

    public void cargar(){
        boolean correcto;
        char opcion;

        do {
            correcto = true;
            opcion = sc.pedirLetra("Desea cargar? (S/N):");

            switch (opcion) {
                case 'S':
                case 's':
                    System.out.println("Cargando datos...");
                    zooService.cargar();
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

    private boolean sonTerrestres(){
        boolean correcto;
        boolean salida = false;

        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿El animal es terrestre? (S/N): ");

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
            id = sc.pideTexto("Introduce el ID del animal(3 LETRAS Y 2 NUMEROS):").toUpperCase();
        } while (!id.matches(regex));

        return id;
    }
}
