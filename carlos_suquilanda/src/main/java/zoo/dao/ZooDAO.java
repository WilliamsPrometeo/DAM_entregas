package zoo.dao;

import models.Animal;
import models.enums.TipoHabitat;
import recursos.Utilidades;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooDAO {
    private static final String RUTA = System.getProperty("user.home") + "/Desktop/DAM/Proyetos/Zoológico/";
    private static final File FICHERO = new File(RUTA + "zoo.dat");

    public void guardar(Map<Animal, TipoHabitat> mapaZoo) {

        if (comprobarDirectorio()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

                oos.writeObject(mapaZoo);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<Animal, TipoHabitat> cargar() {
        Map<Animal, TipoHabitat> mapaZoo = new LinkedHashMap<>();
        if (FICHERO.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {

            mapaZoo = (Map<Animal, TipoHabitat>) ois.readObject();

            } catch(IOException | ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        return mapaZoo;
    }

    private static boolean comprobarDirectorio() {
        if (Utilidades.existDirectory(RUTA)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(RUTA);
        }
    }
}
