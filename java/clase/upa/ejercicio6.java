package clase.upa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numeros.add(random.nextInt(100) + 1);
        }

        System.out.println("Lista generada: " + numeros);
        System.out.print("Ingrese un numero para buscar en la lista: ");
        int buscado = scanner.nextInt();

        if (numeros.contains(buscado)) {
            System.out.println("El numero SI se encuentra en la lista.");
        } else {
            System.out.println("El numero NO se encuentra en la lista.");
        }

        scanner.close();
    }
}
