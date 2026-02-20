package zoo.dao;

import zoo.models.Animal;
import zoo.models.enums.Habitat;
import zoo.recursos.Utilidades;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalDAO {
    private static final String RUTA = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Animales/";
    private static final File FICHERO = new File(RUTA + "animales.dat");

    public void guardar(Map<Animal, Habitat> datos) {

        if (comprobarDirectorio()) {

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

                oos.writeObject(datos);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Map<Animal, Habitat> cargar() {
        Map<Animal, Habitat> datos = new LinkedHashMap<>();
        if (FICHERO.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {

                datos = (Map<Animal, Habitat>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return datos;
    }


    private static boolean comprobarDirectorio() {
        if (Utilidades.existDirectory(RUTA)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(RUTA);
        }
    }
}
