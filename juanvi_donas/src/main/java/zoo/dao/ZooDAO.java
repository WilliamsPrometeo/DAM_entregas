package zoo.dao;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import zoo.models.Animal;
import zoo.models.enums.Habitat;

public class ZooDAO {

    private static final String BASE_PATH =
            System.getProperty("user.home") + File.separator +
                    "Desktop" + File.separator +
                    "DAM" + File.separator +
                    "Proyectos" + File.separator +
                    "Zoologico";

    private static final String FILE_PATH =
            BASE_PATH + File.separator + "zoo.dat";

    public void save(Map<Animal, Habitat> data) throws IOException {

        File directory = new File(BASE_PATH);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(FILE_PATH);

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(data);
        }

        System.out.println("Archivo guardado en:");
        System.out.println(FILE_PATH);
    }

    @SuppressWarnings("unchecked")
    public Map<Animal, Habitat> load() throws IOException, ClassNotFoundException {

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("No existe archivo previo. Se inicia vacío.");
            return new HashMap<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            return (Map<Animal, Habitat>) ois.readObject();
        }
    }
}