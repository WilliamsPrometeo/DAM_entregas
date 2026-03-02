package proyecto04.zoo.dao;

import proyecto04.zoo.models.Animal;
import proyecto04.zoo.models.enums.Habitat;
import recursos.Utilidades;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooDAO {

    private static final String RUTA = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Zoologico/";
    private static final File FICHERO = new File(RUTA + "zoo.dat");

    public void guardar(Map<Animal, Habitat> reservas) {

        if (comprobarDirectorio()) {

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

                oos.writeObject(reservas);

            } catch (IOException e) {
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
            }
        }
        return ubicaciones;
    }


    private static boolean comprobarDirectorio() {
        if (Utilidades.existDirectory(RUTA)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(RUTA);
        }
    }
}
