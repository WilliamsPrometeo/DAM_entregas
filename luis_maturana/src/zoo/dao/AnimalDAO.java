package zoo.dao;

import zoo.Utilidades;
import zoo.models.Animal;
import zoo.models.enums.Habitat;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalDAO {
    private static final String RUTA = System.getProperty("user.home") + "Desktop/DAM/Proyectos/Zoológico";
    private static final File FICHERO = new File(RUTA + "zoo.dat");

    public void guardar(Map<Animal, Habitat> animals) {

        if (comprobarDirectorio()) {
            try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

                oss.writeObject(animals);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<Animal, Habitat> cargar() {
        Map<Animal, Habitat> animals = new LinkedHashMap<>();
        if (FICHERO.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {

                animals = (Map<Animal, Habitat>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return animals;
    }

    private static boolean comprobarDirectorio() {
        if (Utilidades.existDirectory(RUTA)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(RUTA);
        }
    }
}

