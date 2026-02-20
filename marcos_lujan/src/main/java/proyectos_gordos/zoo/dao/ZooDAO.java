package proyectos_gordos.zoo.dao;

import proyectos_gordos.recursos.Utilidades;
import proyectos_gordos.zoo.models.Animal;
import proyectos_gordos.zoo.models.enums.Habitat;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;




public class ZooDAO {
    private static String RUTA = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Zoológico/";
    private static final File FICHERO = new File(RUTA + "zoo.dat");

    public void guardar(Map<Animal, Habitat> animal) {

        if (comprobarDirectorio()) {

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

                oos.writeObject(animal);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    @SuppressWarnings("unchecked")
    public Map<Animal, Habitat> cargar() {
        Map<Animal, Habitat> animal = new LinkedHashMap<>();
        if (FICHERO.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {

                animal = (Map<Animal, Habitat>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return animal;
    }

    private static boolean comprobarDirectorio() {
        if (Utilidades.existDirectory(RUTA)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(RUTA);
        }
    }
}
