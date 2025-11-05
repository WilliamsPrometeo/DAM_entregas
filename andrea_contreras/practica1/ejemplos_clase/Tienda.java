package Practica01.ejemplos_clase;

import Clases.MyScanner;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

    private static List<Videojuego> catalogo;

    //Contructor

    public Tienda() {
        catalogo = new ArrayList<>();
    }


    //Getters y Setters

    public static List<Videojuego> getCatalogo() {
        return catalogo;
    }

    public static void setCatalogo(List<Videojuego> catalogo) {
        Tienda.catalogo = catalogo;
    }

    //Metodos

    public void listarVideojuegos(){

        System.out.println("Listando de videojuegos en tienda...");

       if(catalogo.isEmpty()){
           System.out.println("No hay videojuegos que mostrar");
       }else{
           for(Videojuego videojuego : catalogo){
               getCatalogo();
               System.out.println(videojuego);
           }
       }
    }

    public void agregarVideojuegos(Videojuego videojuego){

//        MyScanner scanner = new MyScanner();
//        int id = scanner.pedirNumero("\nIntroduce el ID del videojuego: ");
//        String titulo = scanner.pedirSoloTexto("Introduce el titulo del videojuego: ");
//        double precio = scanner.pedirNumero("Introduce el precio del videojuego: ");
        catalogo.add(videojuego);

        System.out.println("Videojuego agregado correctamente");

    }

    public Videojuego bucarporId(int id){

        for(Videojuego videojuego : catalogo){
            if (videojuego.getId() == id) {
                return videojuego;
            }
        }
        return null;
    }

    public boolean eliminarporId(int id) throws TiendaExeception{

        Videojuego videojuego = bucarporId(id);
        if(videojuego != null){
            catalogo.remove(videojuego);
            return true;
        }else{
            throw new TiendaExeception("No se encontro el videojuego");
        }
    }




}
