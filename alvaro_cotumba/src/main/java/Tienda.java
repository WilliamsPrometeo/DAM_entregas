
import java.util.ArrayList;

public class Tienda {
    ArrayList<Videojuego> catalogo;

    public Tienda() {
        catalogo = new ArrayList<>();
    }

    public static void listarVideojuego() {
    }

    public ArrayList<Videojuego> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Videojuego> catalogo) {
        this.catalogo = catalogo;
    }

    public void agregarVidejuego(Videojuego videojuegos){
        catalogo.add(videojuegos);
    }

    public void listarVidejuego(){
        if (getCatalogo().isEmpty()) {
            System.out.println("No se videjuegos que mostrar. ");
        }else{
            for(Videojuego item : catalogo){
                System.out.println(item);
            }
        }
    }

    public Videojuego buscarPorId (int id){
        for(Videojuego item: catalogo){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }
     public boolean eliminarPorId(int id) throws TiendaException {
        Videojuego videojuegos = buscarPorId(id);
        if(videojuegos != null){
            catalogo.remove(videojuegos);
        }else {
            throw new TiendaException("No existe ese videojuego");
        }
        return true;
     }
}
