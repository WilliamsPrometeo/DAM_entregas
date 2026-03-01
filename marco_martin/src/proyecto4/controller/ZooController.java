package proyecto4.controller;

import proyecto4.exceptions.InvalidAnimalException;
import proyecto4.exceptions.InvalidDateException;
import proyecto4.models.Animal;
import proyecto4.models.Ave;
import proyecto4.models.Mamifero;
import proyecto4.models.enums.Habitat;
import proyecto4.service.ZooService;
import recursos.MyScanner;
import proyecto4.recursos.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {
    private static final MyScanner sc = new MyScanner();
    private final ZooService service = new ZooService();

    public void addAnimal() {
        boolean correcto;
        String idAnimal = "";

        do {
            correcto = true;
            idAnimal = getIdAnimal();

            try {
                service.registroValido(idAnimal);
            } catch (InvalidAnimalException e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fecha = null;
        do {
            correcto = true;
            try {
                String fechaRegistro = sc.pideTexto("Introduzca la fecha de registro del animal: (YYYY-MM-DD)");
                fecha = LocalDate.parse(fechaRegistro);
                service.fechaValida(fecha);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("ERROR: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué tipo de animal quieres registrar?: " +
                    "\n 1. Registro Mamífero" +
                    "\n 2. Registro Ave" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addAnimal(new Mamifero(idAnimal, fecha, 6),
                            Utilidades.pedirEnum(Habitat.class, "Introduzca el tipo de Habitat: "));
                    break;
                case 2:
                    service.addAnimal(new Ave(idAnimal, fecha, puedeVolar()),
                            Utilidades.pedirEnum(Habitat.class, "Introduzca el tipo de Habitat: "));
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    correcto = false;
                    break;
            }
        }while (!correcto);
    }
    public void listAnimales() {Utilidades.imprimirMap(service.getAnimales());}

    public void getAnimal() {
        String idAnimal = getIdAnimal() ;

        Animal animal = service.getAnimal(idAnimal);
        if (animal != null) {
            System.out.println(animal);
        }else  {
            System.out.println("Animal no encontrado");
        }
    }

    public void eliminarAnimal() {
        String idAnimal=getIdAnimal();

        if (service.eliminarAnimal(idAnimal)) {
            System.out.println("Animal eliminado correctamente");
        } else  {
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
            char opcion = sc.pedirLetra("¿El animal puede volar? (S/N): ");
            switch (opcion) {
                case 'S':
                case 's':
                    salida = true;
                    break;
                case 'N':
                case 'n':
                    break;
                default:
                    System.out.println("Opcion no valida, por favor, vuelva a intentarlo");
                    correcto = false;
                    break;
            }
        } while (!correcto);
        return salida;
    }

    private String getIdAnimal() {
        String regex="^[A-Za-z]{3}[0-9]{2}$";
        String idAnimal;

        do {
            idAnimal=sc.pideTexto("Introduzca el código de registro del animal: Ejemplo válido: ABC12");
            if (!idAnimal.matches(regex)) {
                System.out.println("El código de registro debe tener 3 letras y 2 números, pruebe de nuevo. Ejemplo válido: ABC12");
            }
        }while (!idAnimal.matches(regex));
        return idAnimal;
    }
}
