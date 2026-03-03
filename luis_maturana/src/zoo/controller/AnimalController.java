package zoo.controller;

import zoo.MyScanner;
import zoo.Utilidades;
import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.Ave;
import zoo.models.Mamifero;
import zoo.models.enums.Habitat;
import zoo.service.AnimalService;

import java.time.DateTimeException;
import java.time.LocalDate;

public class AnimalController {

    private static final MyScanner sc = new MyScanner();

    private final AnimalService service = new AnimalService();

    public void añadirAnimal() {
        boolean correcto;
        String idAnimal = "";

        do {
            correcto = true;
            idAnimal = getCodigo();
                    try {
                        service.existeAnimal(idAnimal);
                    } catch (InvalidAnimalException ex) {
                        System.out.println(ex.getMessage());
                        correcto = false;
                    }
        }while (!correcto);

        LocalDate fechaRegistro = null;
        do{
            correcto = true;
            try{
                String fecha = sc.pideTexto("Introduce la fecha de registro (yyyy-MM-dd): ");
                fechaRegistro = LocalDate.parse(fecha);
                service.fechaValida(fechaRegistro);
            }catch (DateTimeException | InvalidDateException ex){
                    System.out.println("Error: " + ex.getMessage());
                    correcto = false;
        }
    }while (!correcto);
         do {
             correcto = true;
             int opcion = sc.pedirNumero("¿Cual animal quieres registrar?: "+
                     "\n1. Ave" +
                     "\n2. Mamifero" +
                     "\nOpcion: ");
             switch(opcion) {
                 case 1:
                     service.registrarAnimal(new Ave(idAnimal, fechaRegistro, nombreAve()),
                             Utilidades.pedirEnum(Habitat.class, "Introduce su habitat"));
                     break;
                 case 2:
                     service.registrarAnimal(new Mamifero(idAnimal, fechaRegistro, raza()),
                             Utilidades.pedirEnum(Habitat.class, "Introduce el habitat"));
                     break;
                 default:
                     System.out.println("Opcion no valida");
                     correcto = false;
                     break;
             }
         }while (!correcto);
    }
    private String raza() {
        String raza = sc.pedirSoloTexto("Introduce la raza del mamifero: ");
        return raza;
    }

    private String nombreAve() {
        String nombre = sc.pedirSoloTexto("Introduce el nombre del animal: ");
        return nombre;
    };

    private String getCodigo() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el id del animal (3 letras y 2 números): ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
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
    public void eliminarAnimal() {
        String codigo = getCodigo();
        if (service.eliminarAnimal(codigo)) {
            System.out.println("Animal eliminado correctamente");
        } else {
            System.out.println("Animal no encontrado");
        }
    }public void getAnimal() {
        String codigo = getCodigo();

        Animal animal = service.getAnimal(codigo);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrado");
        }
    }
    public void listarAnimales() {
        Utilidades.imprimirMap(service.getAnimals());
    }

}
