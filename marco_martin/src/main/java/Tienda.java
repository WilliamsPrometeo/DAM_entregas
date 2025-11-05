import java.util.ArrayList;

public class Tienda {
    ArrayList<Videojuego> videojuegos;

    public Tienda() {
        videojuegos = new ArrayList<>();
    }

    public ArrayList<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(ArrayList<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }

    public void añadirVideojuego(Videojuego videojuego){
        videojuegos.add(videojuego);
    }
    public void listarVideojuegos(){
        if(videojuegos.isEmpty()){
            System.out.println("No hay videojuegos encontrados");
        } else {
            for(Videojuego item : videojuegos){
                System.out.println(item+ "\n");
            }
        }
    }
    public Videojuego buscarVideojuego(int id){
        Videojuego videojuego = null;
        for(Videojuego item : videojuegos){
            if (id==item.getId()){
                return item;
            }
        } return null;
    }
    public boolean eliminarVideojuegoPorID(int id) throws EliminarJuego{
        Videojuego videojuego = buscarVideojuego(id);

        if  (videojuego != null) {
            videojuegos.remove(videojuego);
        } else {
            throw new EliminarJuego("No existe ese videojuego, imbecil\n ");
        }

        return true;

    }
}
