package proyecto_04.dao;


import proyecto_03.utilidades.Utilidades;
import proyecto_04.models.Animal;
import proyecto_04.models.enums.Habitat;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooDAO {
    private static final String RUTA = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Zoológico/";
    private static final File FICHERO = new File(RUTA + "zoo.dat");

    public void guardar(Map<Animal, Habitat> ubicaciones) {
        if (comprobarDirectorio()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
                oos.writeObject(ubicaciones);
            } catch (IOException e) {
                System.out.println("Error guardando: " + e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Map<Animal, Habitat> cargar() {
        Map<Animal, Habitat> ubicaciones = new LinkedHashMap<>();
        if (FICHERO.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {
                ubicaciones = (Map<Animal, Habitat>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error cargando: " + e.getMessage());
            }
        }
        return ubicaciones;
    }

    private static boolean comprobarDirectorio() {
        if (Utilidades.existDirectorio(RUTA)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(RUTA);
        }
    }
}
