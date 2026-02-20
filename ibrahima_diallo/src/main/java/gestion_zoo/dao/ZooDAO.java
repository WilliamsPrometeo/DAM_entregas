package gestion_zoo.dao;

import gestion_zoo.models.Animal;
import gestion_zoo.models.enums.TipoHabitat;
import recursos.Utilidades;


import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooDAO {
    private static final String RUTA = System.getProperty("user.home") + "/Desktop/DAM/Simulacros/Animales/";
    private static final File FICHERO = new File(RUTA + "animales.dat");

    public void guardar(Map<Animal, TipoHabitat> animales) {

        if (comprobarDirectorio()) {

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

                oos.writeObject(animales);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Map<Animal, TipoHabitat> cargar() {
        Map<Animal, TipoHabitat> animales = new LinkedHashMap<>();
        if (FICHERO.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {

                animales = (Map<Animal, TipoHabitat>) ois.readObject();

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
