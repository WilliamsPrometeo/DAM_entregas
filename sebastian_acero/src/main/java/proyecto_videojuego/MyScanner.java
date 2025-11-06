package proyecto_videojuego;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    private static Scanner sc;

    public MyScanner() { sc = new Scanner(System.in); }

    public int pedirNumero(String mns) {
        int n = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println(mns);
                n = sc.nextInt();
                sc.nextLine();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un numero!");
                sc.nextLine();
            }
        }
        return n;
    }

    public double pedirDecimal(String mns) {
        double num = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println(mns);
                num = sc.nextDouble();
                sc.nextLine();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un numero!");
                sc.nextLine();
            }
        }
        return num;
    }
    public String pedirSoloTexto(String texto) {
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÜÁÉÍÓÚÑñ]+");
            if (valido) {
                System.out.println("Error: solo se permiten letras. Intentalo de nuevo");
            }
        } while (!valido);
        return input;
    }

    public char pedirLetra(String texto) {
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÜÁÉÍÓÚÑñ ]");
            if (!valido) {
                System.out.println("Error: solo se permite introducit una letra.Intentalo de nuevo.");
            }
        } while (!valido);

        return input.charAt(0);
    }

    public String pideTexto(String mensaje) {
        String texto;
        do  {
            System.out.println(mensaje);
            texto = sc.nextLine();
            if (!texto.isEmpty()) {
                System.out.println("Error: Este campo no puede estar vacio.");
            }
        } while (!texto.isEmpty());
        return texto;
    }

    public void cerrar() { sc.close(); }
}
