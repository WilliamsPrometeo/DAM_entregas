import java.util.ArrayList;

public class Tienda {

    private ArrayList<VideoJuego> catalogo;

    public Tienda() {
        this.catalogo = new ArrayList<>();
    }

    public ArrayList<VideoJuego> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<VideoJuego> catalogo) {
        this.catalogo = catalogo;
    }
    public void agregar(VideoJuego v){
        catalogo.add(v);
        System.out.println("Agregado VideoJuego");
    }
    public void listar(){
        if(catalogo.isEmpty()){
            System.out.println(" Noy hay videojuegos en el catalogo");
        }else {
            System.out.println(" Videojuegos en el catalogo");
            for (VideoJuego v : catalogo) {
                System.out.println(v);
            }
        }
    }
    public VideoJuego buscarPorId(int id){
        for (VideoJuego v : catalogo) {
            if (v.getId() ==id){
                return v;
            }
        }
        return null;
    }
    public boolean eliminarPorId(int id){
        VideoJuego v = buscarPorId(id);
        if (v != null){
            catalogo.remove(v);
            System.out.println("Eliminado VideoJuego");
            return true;
        }else  {
            System.out.println("No se ha encontrado VideoJuego");
            return false;
        }
    }
}
