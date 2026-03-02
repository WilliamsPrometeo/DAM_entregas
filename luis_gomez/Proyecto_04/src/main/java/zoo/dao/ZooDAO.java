package zoo.dao;

import zoo.models.Animal;
import zoo.models.enums.TipoHabitat;
import zoo.recursos.MyLogger;
import zoo.recursos.Utilidades;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooDAO {
    private static final String RUTA = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Zoológico/";
    private static final File FICHERO = new File(RUTA + "zoo.dat");

    public void guardar(Map<Animal, TipoHabitat> ubicaciones) {
        if (comprobarDirectorio()) {
            MyLogger.logInfo(ZooDAO.class.getSimpleName(), "Iniciando guardado de datos");

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

                oos.writeObject(ubicaciones);
                MyLogger.logInfo(ZooDAO.class.getSimpleName(), "Datos guardados correctamente");

            } catch (IOException e) {
                MyLogger.logError(ZooDAO.class.getSimpleName()
                        , "Error al guardar datos"
                        , e);
                System.out.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Map<Animal, TipoHabitat> cargar() {
        Map<Animal, TipoHabitat> ubicaciones = new LinkedHashMap<>();
        if (FICHERO.exists()) {
            MyLogger.logInfo(ZooDAO.class.getSimpleName(), "Accediendo a fichero de datos");
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {

                ubicaciones = (Map<Animal, TipoHabitat>) ois.readObject();
                MyLogger.logInfo(ZooDAO.class.getSimpleName(), "Datos cargados correctamente");

            } catch (IOException | ClassNotFoundException e) {
                MyLogger.logError(ZooDAO.class.getSimpleName(),
                        "Error al cargar los datos",
                        e);
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
