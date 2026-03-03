package proyecto_04.dao;

import SegundoTrimestre.recursos.Utilidades;
import proyecto_04.models.Animal;
import proyecto_04.models.enums.Habitad;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooDao {
    private static final String RUTA = System.getProperty("user.home") + "Desktop/DAM/Proyetos/Zoológico";
    private static final File FICHERO = new File(RUTA + "zoo.dat");

    public void guardar(Map<Animal, Habitad> animales) throws FileNotFoundException {
        if (comprobarDirectorio()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

                oos.writeObject(animales);
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<Animal, Habitad> cargar() {
        Map<Animal, Habitad> animales = new LinkedHashMap<>();
        if(FICHERO.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {

                animales = (Map<Animal, Habitad>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
       return null;
    }

    private static boolean comprobarDirectorio() {
        if (Utilidades.existeArchivo(RUTA)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(RUTA);
        }
    }
}
