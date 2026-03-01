package proyecto4.recursos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



import static proyecto4.recursos.Utilidades.crearDirectorio;
import static proyecto4.recursos.Utilidades.existeDirectorio;

public class MyLogger {
    private static final String CARPETA_LOGS= "Logs";

    public static void logError(String nombreClase, String mensaje, Exception e){
        if (comprobarDirectorio(CARPETA_LOGS)) {
            String fecha = LocalDate.now().toString();
            String nombreArchivo = "Log: "+ fecha + "_"+ nombreClase + ".txt";

            File archivo= new File(CARPETA_LOGS+File.separator+nombreArchivo);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                String hora= LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

                bw.write(" [ "+hora+" ] ERROR:"+ mensaje +"\n");
                bw.newLine();

                if (e != null) {
                    bw.write(e.toString());
                    bw.newLine();
                }
                bw.write("----------------------------------");
                bw.newLine();
            } catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }

    }
    public static void logInfo(String infoClase, String mensaje){
        if (comprobarDirectorio(CARPETA_LOGS)) {
            String fecha = LocalDate.now().toString();
            String nombreArchivo = "Log: "+ fecha + "_"+ infoClase + ".txt";


            File archivo= new File(CARPETA_LOGS+File.separator+nombreArchivo);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                String hora= LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

                bw.write(" [ "+hora+" ] ERROR:"+ mensaje +"\n");
                bw.newLine();

                bw.write("----------------------------------");
                bw.newLine();
            } catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }



    }
    public static boolean comprobarDirectorio(String ruta) {
        if (existeDirectorio(ruta)) {
            return true;
        } else {
            return crearDirectorio(ruta);
        }
    }
}
