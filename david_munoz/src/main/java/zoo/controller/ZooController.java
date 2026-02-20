package zoo.controller;

import exceptions.InvalidAnimalException;
import exceptions.InvalidDateException;
import models.*;
import models.enums.Habitat;
import recursos.MyScanner;
import recursos.Utilidades;
import service.ZooService;

import java.time.LocalDate;
import java.util.Map;

public class ZooController {

    private ZooService service;
    private MyScanner sc = new MyScanner();

    public ZooController(ZooService service) {
        this.service = service;
    }

    public void registrar() {
        try {
            String id = sc.pideTexto("Introduce ID (3 letras y 2 números): ");

            int year = sc.pedirNumero("Año de registro: ");
            int month = sc.pedirNumero("Mes: ");
            int day = sc.pedirNumero("Día: ");

            LocalDate fecha = LocalDate.of(year, month, day);

            int tipo = sc.pedirNumero("1. Mamífero\n2. Ave");

            models.Animal animal;

            if (tipo == 1) {
                boolean salvaje =
                        sc.pedirNumero("¿Es salvaje? 1.Sí 2.No") == 1;
                animal = new Mamifero(id, fecha, salvaje);
            } else {
                double env = sc.pedirDecimal("Envergadura: ");
                animal = new Ave(id, fecha, env);
            }

            Habitat habitat = Utilidades.pedirEnum(
                    Habitat.class,
                    "Selecciona hábitat:"
            );

            service.registrarAnimal(animal, habitat);

            System.out.println("Animal registrado correctamente.");

        } catch (InvalidAnimalException | InvalidDateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listar() {
        Map<models.Animal, Habitat> data = service.listar();
        if (data.isEmpty()) {
            System.out.println("No hay animales.");
        } else {
            for (Map.Entry<models.Animal, Habitat> entry : data.entrySet()) {
                System.out.println(entry.getKey()
                        + " | Habitat: " + entry.getValue());
            }
        }
    }

    public void buscar() {
        String id = sc.pideTexto("Introduce ID:");
        models.Animal animal = service.buscar(id);

        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("No encontrado.");
        }
    }

    public void eliminar() {
        String id = sc.pideTexto("Introduce ID:");
        if (service.eliminar(id)) {
            System.out.println("Eliminado correctamente.");
        } else {
            System.out.println("No existe ese animal.");
        }
    }

    public void guardar() {
        service.guardar();
    }

    public void cargar() {
        service.cargar();
    }
}


