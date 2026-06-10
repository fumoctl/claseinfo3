package clase.upa;

import java.util.Random;
import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String continuar;

        do {
            int numeroLoteria = random.nextInt(90) + 10;

            System.out.print("Ingrese un numero de 2 digitos: ");
            int numeroUsuario = scanner.nextInt();

            if (numeroUsuario == numeroLoteria) {
                System.out.println("Ganaste! El numero era " + numeroLoteria);
            } else {
                System.out.println("No ganaste. El numero era " + numeroLoteria);
            }

            System.out.print("Desea jugar otra vez? (s/n): ");
            continuar = scanner.next().trim().toLowerCase();
        } while (continuar.equals("s"));

        scanner.close();
    }
}
