package Clases;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    private static Scanner sc;

    public MyScanner() {
        sc = new Scanner(System.in);
    }

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
                System.out.println("Eso no es número!");
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
                System.out.printf(mns);
                num = sc.nextDouble();
                sc.nextLine();
                flag = false;
            }catch (InputMismatchException e) {
                System.out.println("Eso no es número!");
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
            valido = input.matches("[a-zA-ZáéíóúüÁÉÍÓÚÜñÑ ]+");
            if (!valido) {
                System.out.println("ERROR: solo se permiten letras (sin números ni símbolos). Inténtalo de nuevo.");
            }
        }  while (!valido);
        return input;
    }

    public char pedirLetra(String texto) {
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúüÁÉÍÓÚÜñÑ ]");
            if (!valido) {
                System.out.println("ERROR: solo se permite introducir una letra. Inténtalo de nuevo.");
            }
        }while (!valido);

        return input.charAt(0);
    }

    public String pideTexto(String mensaje) {
        String texto;
        do {
            System.out.println(mensaje);
            texto = sc.nextLine();
            if (texto.isEmpty()) {
                System.out.println("Error: el campo no puede estar vacio.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public Double pedirDoublePositivo(String mensaje) {
        Double num = -1.0;
        boolean valido = true;
        while(valido){
            try{
                System.out.println(mensaje);
                num = sc.nextDouble();
                sc.nextLine();
                if(num <= 0){
                    System.out.println("Error: el numero tiene que ser mayor que 0");
                }else{
                    valido = false;
                }
            }catch (InputMismatchException e){
                System.out.println("Eso no es un numero.");
                sc.nextLine();
            }
        }
        return num;
    }

    public void cerrar() {
        sc.close();
    }
}
