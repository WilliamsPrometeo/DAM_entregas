package Clases;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    private static Scanner sc;

    public MyScanner() {
        sc = new Scanner(System.in);
    }

    public int pedirNumero2(String mns) {
        int n1 = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.print(mns);
                n1 = sc.nextInt();
                sc.nextLine();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un numero");
                sc.nextLine();
            }
        }
        return n1;
    }

    public double pedirNumero(String mns) {
        double n = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.print(mns);
                n = sc.nextDouble();
                sc.nextLine();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un numero");
                sc.nextLine();
            }
        }
        return n;
    }

    public String pedirSoloMns(String mns) {
        String input;
        boolean valido;
        do {
            System.out.print(mns);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáàéíóúÁÀÉÍÓÚñÑçÇ ]+");
            if (!valido) {
                System.out.println("ERROR: solo se permiten letras (sin números ni simbolos). Intetalo de nuevo");
            }
        } while (!valido);
        return input;
    }

    public char pedirLetra(String mns) {
        String input;
        boolean valido;
        do {
            System.out.print(mns);
            input=  sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáàéíóúÁÀÉÍÓÚñÑçÇ ]");
            if (!valido) {
                System.out.println("ERROR: solo se permite una letra (sin números ni simbolos). Intetalo de nuevo");
            }
        } while (!valido);
        return input.charAt(0);
    }
    public String pideTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine();
            if (texto.isEmpty()) {
                System.out.println("Error: el campo no puede estar vacio.");
            }
        } while (texto.isEmpty());
        return texto;
    }
    public void cerrar() {
        sc.close();
    }
}
