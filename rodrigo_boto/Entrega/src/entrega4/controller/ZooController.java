package entrega4.controller;

import entrega4.exceptions.InvalidAnimalException;
import entrega4.exceptions.InvalidDateException;
import entrega4.models.Animal;
import entrega4.models.Ave;
import entrega4.models.Mamifero;
import entrega4.models.enums.Habitat;
import entrega4.service.ZooService;
import recursos.MyScanner;
import recursos.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class ZooController {
    private static final MyScanner sc = new MyScanner();

    private final ZooService ubicaciones = new ZooService();

    public void addAnimal(){
        boolean correcto;
        String id_animal = "";
        do {
            correcto = true;
            id_animal = getCodigo();
            try{
                ubicaciones.existeAnimal(id_animal);
            } catch (InvalidAnimalException ex){
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fechaRegistro = null;
        do{
            correcto = true;
            try{
                String registro = sc.pideTexto("Introduce la fecha de registro (yyyy-MM-dd): ");
                fechaRegistro = LocalDate.parse(registro);
                ubicaciones.fechaValida(fechaRegistro);
            } catch (DateTimeParseException | InvalidDateException ex){
                System.out.println("Error:  " + ex.getMessage());
                correcto = false;
            }
        } while(!correcto);

        do{
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué animal quieres añadir?: " +
                    "\n1. Ave" +
                    "\n2. Mamífero" +
                    "\nOpción: ");
            switch (opcion) {
                case 1:
                    ubicaciones.addAnimal(new Ave(id_animal, fechaRegistro, puedeVolar()),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el hábitat del animal: "));
                    break;
                case 2:
                    ubicaciones.addAnimal(new Mamifero(id_animal, fechaRegistro, 4),
                            Utilidades.pedirEnum(Habitat.class, "Introduce el hábitat del animal: "));
                    break;
                default:
                    System.out.println("Opción no válida");
                    correcto = false;
                    break;
            }
        } while(!correcto);
    }

    public void listarAnimales(){
        Utilidades.imprimirMap(ubicaciones.getAnimal());
    }

    public void getAnimal(){
        String id_animal = getCodigo();

        Animal animal = ubicaciones.getAnimal(id_animal);
        if (animal != null){
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    public void guardar(){
        boolean correcto;
        char opcion;
        do{
            correcto = true;
            opcion = sc.pedirLetra("¿Desea guardar? (S/N): ");
            switch (opcion) {
                case 'S':
                case 's':
                    System.out.println("Guardando datos..");
                    ubicaciones.guardar();
                    break;
                case 'N':
                case 'n':
                    break;
                default:
                    System.out.println("Opción no válida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    public void cargar(){
        boolean correcto;
        char opcion;
        do{
            correcto = true;
            opcion = sc.pedirLetra("¿Desea cargar? (S/N): ");
            switch (opcion) {
                case 'S':
                case 's':
                    System.out.println("Cargando datos..");
                    ubicaciones.cargar();
                    break;
                case 'N':
                case 'n':
                    break;
                default:
                    System.out.println("Opción no válida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    public void eliminarAnimal(){
        String id_animal = getCodigo();
        if (ubicaciones.eliminarAnimal(id_animal)){
            System.out.println("Animal eliminado");
        } else {
            System.out.println("Animal no encontrado");
        }
    }

    private boolean puedeVolar() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿Este ave puede volar? (S/N)");
            switch (opcion) {
                case 'S':
                case 's':
                    salida = true;
                case 'N':
                case 'n':
                    break;
                default:
                    System.out.println("Opción no válida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
        return salida;
    }

    private String getCodigo() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String id_animal;
        do {
            id_animal = sc.pideTexto("Introduce el id del animal (3 letras y 2 números): ").toUpperCase();
        } while (!id_animal.matches(regex));
        return id_animal;
    }
}
