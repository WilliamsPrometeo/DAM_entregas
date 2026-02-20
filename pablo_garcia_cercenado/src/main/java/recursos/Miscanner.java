package recursos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Miscanner {
    private static Scanner sc;

    public Miscanner() {
        sc = new Scanner(System.in);
    }

    public int pedirNumero(String s){
        int n = -1;
        boolean flag = true;
        while(flag){
            try{
                System.out.println(s);
                n=sc.nextInt();
                sc.nextLine();
                flag = false;
            }
            catch(InputMismatchException e){
                System.out.println("Error: Por favor ingrese un numero");
                sc.next();
            }
        }
        return n;
    }

    public String pedirsoloTexto(String texto){
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑäëïöüÄËÏÖÜ ]+");
            if(!valido){
                System.out.println("Solo se permiten letras, sin numeros ni simbolos, intentalo de nuevo.");
            }
        } while(!valido);
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
}
