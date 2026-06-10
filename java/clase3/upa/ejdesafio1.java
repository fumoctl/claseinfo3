package clase3.upa;

import java.util.Random;
import java.util.Scanner;

public class ejdesafio1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		boolean seguirJugando = true;

		while (seguirJugando) {
			int[] numerosSorteo = generarNumerosSorteo(random);
			int[] numerosUsuario = leerNumerosUsuario(scanner);

			String resultado = evaluarPremio(numerosSorteo, numerosUsuario);
			System.out.println(resultado);

			System.out.print("\nDeseas jugar otra vez? (s/n): ");
			String respuesta = scanner.next().trim().toLowerCase();
			seguirJugando = respuesta.equals("s") || respuesta.equals("si");
			System.out.println();
		}

		scanner.close();
	}

	private static int[] generarNumerosSorteo(Random random) {
		int[] numeros = new int[3];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = random.nextInt(90) + 10;
		}
		return numeros;
	}

	private static int[] leerNumerosUsuario(Scanner scanner) {
		int[] numeros = new int[3];
		System.out.println("Ingresa 3 numeros de 2 digitos (10 a 99):");

		for (int i = 0; i < numeros.length; i++) {
			while (true) {
				System.out.print("Numero " + (i + 1) + ": ");

				if (scanner.hasNextInt()) {
					int valor = scanner.nextInt();
					if (valor >= 10 && valor <= 99) {
						numeros[i] = valor;
						break;
					}
				} else {
					scanner.next();
				}

				System.out.println("Entrada invalida. Debe ser un numero de 2 digitos.");
			}
		}

		return numeros;
	}

	private static String evaluarPremio(int[] sorteo, int[] usuario) {
		if (coincidenEnOrdenExacto(sorteo, usuario)) {
			return "Ganaste el premio mayor";
		}

		if (coincidenMismosTresEnDistintoOrden(sorteo, usuario)) {
			return "Ganaste el segundo premio";
		}

		int coincidencias = contarCoincidenciasPorValor(sorteo, usuario);
		if (coincidencias == 1 || coincidencias == 2) {
			return "Ganaste el tercer premio";
		}

		return "No hubo coincidencias. Sigue intentando";
	}

	private static boolean coincidenEnOrdenExacto(int[] sorteo, int[] usuario) {
		for (int i = 0; i < sorteo.length; i++) {
			if (sorteo[i] != usuario[i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean coincidenMismosTresEnDistintoOrden(int[] sorteo, int[] usuario) {
		int[] frecuenciaSorteo = new int[100];
		int[] frecuenciaUsuario = new int[100];

		for (int i = 0; i < sorteo.length; i++) {
			frecuenciaSorteo[sorteo[i]]++;
			frecuenciaUsuario[usuario[i]]++;
		}

		for (int i = 10; i <= 99; i++) {
			if (frecuenciaSorteo[i] != frecuenciaUsuario[i]) {
				return false;
			}
		}

		return true;
	}

	private static int contarCoincidenciasPorValor(int[] sorteo, int[] usuario) {
		int[] frecuenciaSorteo = new int[100];
		int[] frecuenciaUsuario = new int[100];

		for (int i = 0; i < sorteo.length; i++) {
			frecuenciaSorteo[sorteo[i]]++;
			frecuenciaUsuario[usuario[i]]++;
		}

		int coincidencias = 0;
		for (int i = 10; i <= 99; i++) {
			coincidencias += Math.min(frecuenciaSorteo[i], frecuenciaUsuario[i]);
		}

		return coincidencias;
	}
}
