package segunda_evaluacion.prueba4.dao;

import segunda_evaluacion.prueba4.models.Animal;
import segunda_evaluacion.prueba4.models.enums.Habitat;
import segunda_evaluacion.prueba4.recursos.Utilidades;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;


public class ZooDAO {

    private static final String RUTA =
            System.getProperty("user.home") + "/Desktop/DAM/Proyetos/Zoológico/";
    private static final File FICHERO = new File(RUTA+"zoo.dat");

    public void guardar(Map<Animal, Habitat> animals) {

        if (comprobarDirectorio()) {

            try (ObjectOutputStream oos =
                         new ObjectOutputStream(new FileOutputStream(FICHERO))) {
                oos.writeObject(animals);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Map<Animal, Habitat> cargar() {

        Map<Animal, Habitat> animals = new LinkedHashMap<>();

        if (FICHERO.exists()) {
            try (ObjectInputStream ois =
                         new ObjectInputStream(new FileInputStream(FICHERO))) {
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
