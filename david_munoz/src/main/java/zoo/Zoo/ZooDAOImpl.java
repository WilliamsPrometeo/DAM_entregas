package zoo.Zoo;

import models.Animal;
import models.enums.Habitat;

import java.io.*;
import java.util.Map;

public class ZooDAOImpl implements ZooDAO {

    private static final String RUTA =
            "Desktop/DAM/Proyetos/Zoológico/zoo.dat";

    @Override
    public void saveToFile(Map<Animal, Habitat> data) {

        File file = new File(RUTA);
        file.getParentFile().mkdirs();

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(data);
            System.out.println("Datos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<Animal, Habitat> loadFromFile() {

        File file = new File(RUTA);

        if (!file.exists()) {
            System.out.println("No existe archivo para cargar.");
            return null;
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            return (Map<Animal, Habitat>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }

        return null;
    }
}
