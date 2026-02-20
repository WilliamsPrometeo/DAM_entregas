package proyecto_04.dao;

import proyectos.proyecto_04.models.Animal;
import proyectos.proyecto_04.models.enums.TipoHabitats;
import recursos.Utilidades;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.io.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalDAO {
    private static final String RUTA = System.getProperty("user.home") + "Desktop/DAM/Proyetos/Zoológico";
    private static final File FICHERO = new File(RUTA + "zoo.dat");

    public void guardar(Map<Animal, TipoHabitats> animales) {

        if (comprobarDirectorio()) {

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

                oos.writeObject(animales);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Map<Animal, TipoHabitats> cargar() {
        Map<Animal, TipoHabitats> animales = new LinkedHashMap<>();
        if (FICHERO.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {

                animales = (Map<Animal, TipoHabitats>) ois.readObject();

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