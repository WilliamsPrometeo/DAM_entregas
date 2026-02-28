package proyecto_4.dao;

import proyecto_4.models.Animal;
import proyecto_4.models.enums.Habitat;
import recursos.Utilidades;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooDAO {
    private static final String RUTA = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Zoológico/";
    private static final File FICHERO = new File(RUTA + "zoo.dat");

    public void guardar(Map<Animal, Habitat> animales) {

        if (comprobarDirectorio()) {

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

                oos.writeObject(animales);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<Animal, Habitat> cargar() {
        Map<Animal, Habitat> animales = new LinkedHashMap<>();
        if (FICHERO.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {

                animales = (Map<Animal, Habitat>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return animales;
    }

    private static boolean comprobarDirectorio() {
        if (Utilidades.existDirectory(RUTA)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(RUTA);
        }
    }
}
