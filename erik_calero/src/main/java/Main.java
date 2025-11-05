import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Myscanner myscanner = new Myscanner();
        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda();
        int selec;
        do{
            System.out.println("========= Menu Tienda =============");
            System.out.println("1. Agregar Videojuego");
            System.out.println("2. Listar Videojuegos");
            System.out.println("3. Buscar Videojuego por ID");
            System.out.println("4. Eliminar Videojuego por ID");
            System.out.println("5. Salir");
            System.out.println("=====================================");
            //System.out.println("ingrese opcioin ");
            selec = Myscanner.pedirNumero("Ingrese opcioin ");
            switch (selec) {
                case 1:
                    try{
                        String titulo = Myscanner.pedirSoloTexto("ingrese titulo del videojuego");
                        double precio = Myscanner.pedirNumero("ingrese valor del videojuego");
                        VideoJuego nuevo = new VideoJuego(titulo,precio);
                        tienda.agregar(nuevo);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                    case 2:
                        tienda.listar();
                        break;
                        case 3:
                            int idBuscar =Myscanner.pedirNumero("Ingrese id de videojuego ");
                            VideoJuego v = tienda.buscarPorId(idBuscar);
                            if(v!=null){
                                System.out.println(" se ha encontrado " + v.getTitulo());
                            }else{
                                System.out.println("No se encontro el videojuego");
                            }
                            break;
                            case 4:
                                int idEliminar = Myscanner.pedirNumero("ingrese el id del videojuego a eliminar");
                                tienda.eliminarPorId(idEliminar);
                                break;
                                case 5:
                                    System.out.println(" SALIENDO DEL MENU GRACIAS");
                                    break;
                default:
                    System.out.println("Opcion no permitida");
            }
        }while(selec!=5);
        sc.close();
    }

}
