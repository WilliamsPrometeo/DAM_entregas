package zoo.controller;

import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.AnimalAve;
import zoo.models.AnimalMamifero;
import zoo.models.enums.Habitat;
import zoo.recursos.MyScanner;
import zoo.recursos.Utilidades;
import zoo.service.AnimalService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {

    private static final MyScanner sc = new MyScanner();

    private final AnimalService service = new AnimalService();

    public void addAnimal() throws InvalidDateException {
        boolean correcto;
        String animalId;
        do {
            correcto = true;
            animalId = getCodigo();
            try {
                service.existeAnimal(animalId);
            }catch (InvalidAnimalException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);


        LocalDate fechaEntrada = null;
        LocalDate fechaSalida = null;
        do {
            correcto = true;
            try {
                String entrada = sc.pideTexto("Introduce la fecha de entrada (yyyy-MM-dd): ");
                fechaEntrada = LocalDate.parse(entrada);
                String salida = sc.pideTexto("Introduce la fecha de salida (yyyy-MM-dd): ");
                fechaSalida = LocalDate.parse(salida);
                service.fechaValida(fechaEntrada, fechaSalida);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Que animal desea registrar?: " +
                    "\n1. Ave" +
                    "\n2. Mamifero" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addAnimal(new AnimalAve(animalId, fechaEntrada, fechaSalida, tipoAve()));
                    Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de Habitat: ");
                    break;
                    case 2:
                        service.addAnimal(new AnimalMamifero(animalId, fechaEntrada, fechaSalida, carnivoro()));
                        Utilidades.pedirEnum(Habitat.class, "Introduce el tipo de Habitat: ");
                        break;
                        default:
                            System.out.println("Opcion no valida");
                            correcto = false;
                            break;
            }
        } while (!correcto);
    }

    public void listarAnimals() {
        Utilidades.imprimirMap(service.getAnimals());
    }

    public String getAnimal() {
        String animalId = getAnimal();

        Animal animal = service.getAnimal(animalId);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println(" El animal no existe");
        }
        return animalId;
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

    private boolean tipoAve() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿El ave es Volador? (S/N): ");
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

    private boolean carnivoro() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿El animal es Carnivoro o Herbiboro? (C/H): ");
            switch (opcion) {
                case 'C':
                case 'c':
                    salida = true;
                    break;
                case 'H':
                case 'h':
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
            codigo = sc.pideTexto("Introduce el código de reserva (3 letras y 2 números): ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
    }
}

