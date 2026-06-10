package clase.upa;

import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la temperatura en grados Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = celsius * 1.8 + 32;
        System.out.println("Temperatura en Fahrenheit: " + fahrenheit);

        scanner.close();
    }
}
