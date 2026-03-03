package zoo.controller;

import exceptions.InvalidAnimalException;
import models.Animal;
import models.Mamifero;
import recursos.MyScanner;
import recursos.Utilidades;
import service.ZooService;

import java.time.LocalDate;


public class ZooController {

    private static final MyScanner sc = new MyScanner();

    private final ZooService service = new ZooService();

    public void addAnimal () {
        boolean correcto;
        String idAnimal = "";
        do {
            correcto = true;
            idAnimal = getId();
            try {
                service.existeAnimal(idAnimal);
            } catch (InvalidAnimalException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fechaNacimiento = null;

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Que animal quiere registar?: " +
                    "\n1.Animal Mamifero" +
                    "\n2.Animal Ave" +
                    "\n OPCIÓN: ");

            switch (opcion) {
                case 1:
                    service.addAnimal(new Mamifero(idAnimal, nombre, edad, fechaNacimiento));
            }
        } while (!correcto);
    }

    public void listarReservas(){
        Utilidades.imprimirMap(service.getAnimal());
    }

    public void getAnimal(){
        String idAnimal = getId();

        Animal animal = service.getAnimal();
        if (animal != null) {
            System.out.println(animal);
        }else {
            System.out.println("Animal no encontrado");
        }
    }

    public void eliminarAnimal(){
        String idAnimal = getId();
        if (service.eliminarAnimal(idAnimal)) {
            System.out.println("Animal eliminado");
        }else  {
            System.out.println("Animal no encontrado");
        }
    }

    public void guardar(){}

    public void cargar(){}

    private String getId() {
        String regex = "^[A-Z]{2}[0-9]{4}$";
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el código de reserva (2 letras y 4 números): ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
    }
}

}
