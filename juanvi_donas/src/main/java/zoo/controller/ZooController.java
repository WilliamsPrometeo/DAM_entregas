package zoo.controller;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import zoo.dao.ZooDAO;
import zoo.models.Animal;
import zoo.models.Ave;
import zoo.models.Mamifero;
import zoo.models.enums.Habitat;
import zoo.repository.ZooRepository;
import zoo.service.ZooService;

public class ZooController {

    private Scanner sc = new Scanner(System.in);


    private ZooRepository repository = new ZooRepository() {
        @Override
        public void addAnimal(Animal animal, Habitat habitat) {

        }

        @Override
        public Animal findById(String id) {
            return null;
        }

        @Override
        public void removeById(String id) {

        }

        @Override
        public Map<Animal, Habitat> findAll() {
            return Map.of();
        }

        @Override
        public void setData(Map<Animal, Habitat> data) {

        }
    };

    private ZooService service = new ZooService(repository);
    private ZooDAO dao = new ZooDAO();

    public void start() {

        int option;

        do {
            mostrarMenu();

            try {
                option = Integer.parseInt(sc.nextLine());

                switch (option) {
                    case 1 -> registrarAnimal();
                    case 2 -> listarAnimales();
                    case 3 -> buscarAnimal();
                    case 4 -> eliminarAnimal();
                    case 5 -> guardar();
                    case 6 -> cargar();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número.");
                option = -1;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                option = -1;
            }

        } while (option != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n========= GESTIÓN DE ZOO =========");
        System.out.println("1. Registrar animal");
        System.out.println("2. Listar animales");
        System.out.println("3. Buscar animal");
        System.out.println("4. Eliminar animal");
        System.out.println("5. Guardar datos");
        System.out.println("6. Cargar datos");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private void registrarAnimal() throws Exception {

        System.out.print("ID (ABC12): ");
        String id = sc.nextLine();

        System.out.print("Fecha (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());

        System.out.println("Tipo:");
        System.out.println("1. Mamífero");
        System.out.println("2. Ave");
        System.out.print("Opción: ");
        int tipo = Integer.parseInt(sc.nextLine());

        Animal animal;

        if (tipo == 1) {
            System.out.print("Tipo de pelaje: ");
            String pelaje = sc.nextLine();
            animal = new Mamifero(id, fecha, pelaje);
        } else if (tipo == 2) {
            System.out.print("Envergadura: ");
            double env = Double.parseDouble(sc.nextLine());
            animal = new Ave(id, fecha, env);
        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        Habitat habitat = seleccionarHabitat();

        service.registrarAnimal(animal, habitat);

        System.out.println("Animal registrado correctamente.");
    }

    private Habitat seleccionarHabitat() {

        System.out.println("Seleccione Habitat:");

        Habitat[] values = Habitat.values();

        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }

        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());

        return values[op - 1];
    }

    private void listarAnimales() {

        Map<Animal, Habitat> datos = service.listar();

        if (datos.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return;
        }

        System.out.println("\n--- LISTA ---");

        datos.forEach((animal, habitat) ->
                System.out.println(animal.getId() + " | "
                        + animal.getTipo() + " | "
                        + animal.getFechaRegistro() + " | "
                        + habitat));
    }

    private void buscarAnimal() {

        System.out.print("ID a buscar: ");
        String id = sc.nextLine();

        Animal a = service.buscarAnimal(id);

        if (a == null)
            System.out.println("No encontrado");
        else
            System.out.println("Encontrado: " + a);
    }

    private void eliminarAnimal() {

        System.out.print("ID a eliminar: ");
        service.eliminarAnimal(sc.nextLine());

        System.out.println("Operación realizada.");
    }

    private void guardar() throws Exception {
        dao.save(service.listar());
        System.out.println("Datos guardados en zoo.dat");
    }

    private void cargar() throws Exception {
        service.reemplazarDatos(dao.load());
        System.out.println("Datos cargados.");
    }
}