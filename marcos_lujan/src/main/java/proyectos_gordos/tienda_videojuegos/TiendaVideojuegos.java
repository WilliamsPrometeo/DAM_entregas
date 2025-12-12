package proyectos_gordos.tienda_videojuegos;

import proyectos_gordos.exceptions.MyExceptionVG;

import java.util.ArrayList;


public class TiendaVideojuegos {
    ArrayList<Videojuegos> listaVideojuegos;

    public TiendaVideojuegos() {listaVideojuegos = new ArrayList<>(); }
    public ArrayList<Videojuegos> getListaVideojuegos() {
        return listaVideojuegos; }

    public void setListaVideojuegos(ArrayList<Videojuegos> listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos; }

    public void registrarVideojuegos(Videojuegos videojuegos) {listaVideojuegos.add(videojuegos);}

    public void listar(){
        if(listaVideojuegos.isEmpty()){
            System.out.println("No existen videojuegos registrados");
        }else {
            for (Videojuegos VG : listaVideojuegos) {
                System.out.println(VG);
            }
        }
    }
    public Videojuegos buscarID(int id){
        for (Videojuegos VG : listaVideojuegos) {
            if (VG.getId() == id) {
                return VG;
            }
        }return null;
    }
    public boolean eliminarByID(int id) throws MyExceptionVG {
        Videojuegos VG = buscarID(id);
        if (VG != null) {
            listaVideojuegos.remove(VG);
        }else{
            throw new MyExceptionVG("No existe dicho videojuego o no lo tenemos por ahora, por favor vuelva en otro momento o revise en la web, " +
                    "pero no se vaya a la competencia o habrá consecuencias 😁👍");
        }
        return true;
    }

}
