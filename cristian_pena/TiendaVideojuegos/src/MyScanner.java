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
                System.out.print(mns);
                n = sc.nextInt();
                sc.nextLine();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un numero");
                sc.nextLine();
            }
        }
        return n;
    }
    public String pedirSoloTexto(String texto){
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
            if (!valido) {
                System.out.println("ERROR: solo se permiten letras (sin numeros ni simbolos). Intentalo de nuevo. ");
            }
        } while (!valido);
        return input;
    }

    public void close() {
    }
}

