package clase.upa;

import java.util.Scanner;

public class ejercicio1 {
	private static boolean esPrimo(int numero) {
		if (numero <= 1) {
			return false;
		}

		for (int i = 2; i * i <= numero; i++) {
			if (numero % i == 0) {
				return false;
			}
		}

		return true;
	}

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese un numero entero: ");
		int numero = scanner.nextInt();

		if (esPrimo(numero)) {
			System.out.println(numero + " es primo.");
		} else {
			System.out.println(numero + " no es primo.");
		}

		scanner.close();
	}
}
