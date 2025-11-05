package ejemplos_clase;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Miscanner {
    private static Scanner sc;

    public Miscanner() {
        sc = new Scanner(System.in);
    }

    public int pedirNumero(String mns){
        int n = -1;
        boolean flag = true;
        while(flag){
            try{
                System.out.println(mns);
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
                System.out.println("Solo se permiten letras, sin números ni símbolos, intentalo de nuevo.");
            }
        } while(!valido);
        return input;
    }
}
