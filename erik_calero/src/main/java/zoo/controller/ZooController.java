package zoo.controller;

import zoo.exceptions.InvalidAnimalExceptions;
import zoo.exceptions.InvalidDateExceptions;
import zoo.models.Animal;
import zoo.models.Ave;
import zoo.models.Mamifero;
import zoo.models.enums.TipoHabitad;
import zoo.recursos.MyScanner;
import zoo.recursos.Utilidades;
import zoo.service.ZooService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ZooController {
    private static final MyScanner scanner = new MyScanner();
    private final ZooService service = new ZooService();

    public void addAnimales() {
        boolean correcto;
        String codigoAnimal = "";
        do {
            correcto = true;
            codigoAnimal = getCodigo();
            try {
                service.animalValido(codigoAnimal);
            } catch (InvalidAnimalExceptions ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fechaRegistro = null;
        do {
            correcto = true;
            try {
                String registro = scanner.pideTexto("Ingrese fecha de registr( yyyy-MM-dd");
                fechaRegistro = LocalDate.parse(registro);
                service.fechaValida(fechaRegistro);
            } catch (DateTimeParseException | InvalidDateExceptions ex) {
                System.out.println("Error" + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = scanner.pedirNumero(" que animal quiere reghistrar \n 1 Mamifero \n 2 Ave \n Opcion");

            switch (opcion) {
                case 1:
                    service.addAnimales(new Mamifero(codigoAnimal, fechaRegistro, scanner.pedirNumero("ingrese el numero de patas")),
                            Utilidades.pedirEnum(TipoHabitad.class, "Ingrese el tipo de habitad"));
                    break;
                case 2:
                    service.addAnimales(new Ave(codigoAnimal, fechaRegistro, scanner.pideTexto("Ingrese color de plumaje")),
                            Utilidades.pedirEnum(TipoHabitad.class, "Ingrese tipo de habitad"));
                    break;
                default:
                    System.out.println("Error opcion no valida");
                    correcto = false;
            }
        } while (!correcto);
    }
    public void listarAnimales(){
        Utilidades.imprimirMap(service.getAnimal());
    }
    public void getAnimal(){
        String codigo = getCodigo();
        Animal animal = service.getAnimal(codigo);
        if(animal != null){
            System.out.println(animal);
        }else {
            System.out.println("Animal no existe");
        }
    }
    public void eliminarAnimal(){
        String codigo = getCodigo();
        if(service.eliminarAnimal(codigo)){
            System.out.println("Animal ejecutando correctamente");
        }else {
            System.out.println("Animal no existe");
        }
    }
    public void guardar(){
        boolean correcto;
        char opcion;
        do {
            correcto = true;
            opcion = scanner.pedirLetra("desea guardar (s/n)");
            switch (opcion) {
                case 's':
                case 'S':
                    System.out.println("guardando datos");
                    service.guardar();
                    break;
                    case 'n':
                case 'N':
                        break;
                default:
                    System.out.println("Error opcion no valida");
            }
        }while (!correcto);
    }
    public void cargar(){
        boolean correcto;
        char opcion;
        do {
            correcto = true;
            opcion = scanner.pedirLetra("desea Cargar (s/n)");
            switch (opcion) {
                case 's':
                    case 'S':
                        System.out.println("Cargarando datos");
                        service.cargar();
                        break;
                        case 'n':
                            case 'N':
                                break;
                                default:
                                    System.out.println("Error opcion no valida");
            }
        }while (!correcto);
    }
    private String getCodigo(){
        String regex = "[A-Z]{3}[0-9]{2}$" ;
        String codigo;
        do{
            codigo = scanner.pideTexto("Ingrese codigo de animal reserve 3 letras y 2 numeros").toUpperCase();
        }while (!codigo.matches(regex));
        return codigo;
    }
}
