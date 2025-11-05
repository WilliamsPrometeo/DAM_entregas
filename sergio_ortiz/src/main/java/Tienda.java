// ===============================================
//  Proyecto: Gestor de Tienda de Videojuegos
//  Autor: [Sergio]
//  Fecha: 05/11/2025
// ===============================================

import java.util.ArrayList;

// =======================
// 🏪 Clase Tienda
// =======================
class Tienda {
    private ArrayList<Videojuego> catalogo;

    public Tienda() {
        this.catalogo = new ArrayList<>();
    }

    public void agregar(Videojuego v) {
        catalogo.add(v);
        System.out.println("✅ Videojuego agregado correctamente.");
    }

    public void listar() {
        if (catalogo.isEmpty()) {
            System.out.println("📭 No hay videojuegos en el catálogo.");
        } else {
            System.out.println("\n🎮 Catálogo de Videojuegos:");
            for (Videojuego v : catalogo) {
                System.out.println(v);
            }
        }
    }

    public Videojuego buscarPorId(int id) {
        for (Videojuego v : catalogo) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    public boolean eliminarPorId(int id) {
        Videojuego v = buscarPorId(id);
        if (v != null) {
            catalogo.remove(v);
            System.out.println("🗑️ Videojuego eliminado correctamente.");
            return true;
        } else {
            System.out.println("⚠️ No se encontró ningún videojuego con ese ID.");
            return false;
        }
    }
}

