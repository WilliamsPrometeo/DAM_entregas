package zoo.dao;

import zoo.models.Animal;
import zoo.models.enums.TipoHabitad;
import zoo.recursos.Utilidades;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooDao {
    private static  final String RUTA = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Zoologico/";
    private static final File FICHERO = new File(RUTA + "zoo.dat");

    public void guardar(Map<Animal, TipoHabitad> animales) {
        if(comprobarDireccion()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
                oos.writeObject(animales);
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<Animal,TipoHabitad > cargar() {
        Map<Animal, TipoHabitad> animales = new LinkedHashMap<>();
        if (FICHERO.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {
                animales = (Map<Animal, TipoHabitad>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return animales;
    }
    private static boolean comprobarDireccion() {
        if (Utilidades.existDirectory(RUTA)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(RUTA);
        }
    }
}
