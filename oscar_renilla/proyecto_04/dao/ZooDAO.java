package programacion.simulacros_Proyectos.segundaEval.proyecto_04.dao;

import programacion.simulacros_Proyectos.segundaEval.proyecto_04.models.Animal;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.models.enums.Habitat;
import recursos.Utilidades;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooDAO {
    private static final String RUTA = System.getProperty("user.home") + "/Desktop/DAM/Proyetos/Zoológico/";
    private static final File FICHERO = new File(RUTA + "zoo.dat");

    public void guardar(Map<Animal, Habitat> ubicaciones) {
        if (comprobarDirectorio()) {

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

                oos.writeObject(ubicaciones);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<Animal, Habitat> cargar() {
        Map<Animal, Habitat> ubicaciones = new LinkedHashMap<>();
        if(FICHERO.exists()) {
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))){
                ubicaciones = (Map<Animal, Habitat>) ois.readObject();
            }catch (IOException | ClassNotFoundException e){
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
