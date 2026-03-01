package proyecto4.dao;

import proyecto4.models.Animal;
import proyecto4.models.enums.Habitat;
import proyecto4.recursos.Utilidades;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalDAO {
    private static final String RUTA=System.getProperty("user.home")+"/Desktop/DAM/Proyetos/Zoológico/";
    private static final File FICHERO=new File(RUTA+"zoo.dat");

    public void guardar(Map<Animal, Habitat> animales){
        if (comprobarDirectorio()){
            try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(FICHERO))){
                oos.writeObject(animales);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
@SuppressWarnings("unchecked")
    public Map<Animal, Habitat> cargar(){
        Map<Animal, Habitat> animales=new LinkedHashMap<>();

        if(FICHERO.exists()){
            try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(FICHERO))){

                animales=(Map<Animal, Habitat>) ois.readObject();

            }catch (IOException | ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        return animales;
    }

    private static boolean comprobarDirectorio() {
        if (Utilidades.existeDirectorio(RUTA)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(RUTA);
        }
    }
}
