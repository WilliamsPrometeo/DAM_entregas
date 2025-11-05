package src;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<Videojuego> catalogo;

        public Tienda() {
            this.catalogo = new ArrayList<>();
        }

        public void anadir(Videojuego vj) {
            catalogo.add(vj);
            System.out.println("Videojuego añadido");
        }

        public void listar() {
            if (catalogo.isEmpty()) {
                System.out.println("No tienes juegos anadidos");
            } else {
                System.out.println("\n=== CATÁLOGO ===");
                for (Videojuego vj : catalogo) {
                    System.out.println(vj.toString());
                }
            }
        }

        public Videojuego buscarPorId(int id) {
            for (Videojuego vj : catalogo) {
                if (vj.getId() == id) {
                    return vj;
                }
            }
            return null;
        }

        public boolean eliminarPorId(int id) {
            Videojuego encontrado = buscarPorId(id);
            if (encontrado != null) {
                catalogo.remove(encontrado);
                return true;
            }
            return false;
        }
    }
