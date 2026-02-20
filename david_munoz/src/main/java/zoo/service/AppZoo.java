package zoo.service;


import controller.ZooController;
import dao.Zoo.ZooDAOImpl;
import recursos.MyScanner;
import repository.ZooRepositoryImpl;
import service.ZooService;

public class AppZoo {

    public static void main(String[] args) {

        ZooRepositoryImpl repository = new ZooRepositoryImpl();
        ZooDAOImpl dao = new ZooDAOImpl();
        ZooService service = new ZooService(repository, dao);
        ZooController controller = new ZooController(service);

        MyScanner sc = new MyScanner();

        int opcion;

        do {
            System.out.println("\n1. Registrar animal");
            System.out.println("2. Listar animales");
            System.out.println("3. Buscar animal");
            System.out.println("4. Eliminar animal");
            System.out.println("5. Guardar datos");
            System.out.println("6. Cargar datos");
            System.out.println("0. Salir");

            opcion = sc.pedirNumero("Elige opción:");

            switch (opcion) {
                case 1 -> controller.registrar();
                case 2 -> controller.listar();
                case 3 -> controller.buscar();
                case 4 -> controller.eliminar();
                case 5 -> controller.guardar();
                case 6 -> controller.cargar();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 0);

        sc.cerrar();
    }
}

