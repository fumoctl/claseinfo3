package ej1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado("Ana Perez", 30, "Dev"));
        empleados.add(new Empleado("Luis Gomez", 28, "Analista"));

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero(scanner, "Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> listarEmpleados(empleados);
                case 2 -> agregarEmpleado(scanner, empleados);
                case 3 -> editarEmpleado(scanner, empleados);
                case 4 -> eliminarEmpleado(scanner, empleados);
                case 5 -> hacerTrabajarEmpleado(scanner, empleados);
                case 6 -> {
                    continuar = false;
                    System.out.println("Programa finalizado.");
                }
                default -> System.out.println("Opcion invalida. Intente otra vez.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Gestion de Empleados ---");
        System.out.println("1. Listar empleados");
        System.out.println("2. Agregar empleado");
        System.out.println("3. Editar empleado");
        System.out.println("4. Eliminar empleado");
        System.out.println("5. Hacer trabajar a un empleado");
        System.out.println("6. Salir");
    }

    private static void listarEmpleados(List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados cargados.");
            return;
        }

        System.out.println("\nLista de empleados:");
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            System.out.println("Empleado #" + (i + 1));
            empleado.mostrar();
            empleado.mostrarPuesto();
            System.out.println();
        }
    }

    private static void agregarEmpleado(Scanner scanner, List<Empleado> empleados) {
        String nombre = leerTexto(scanner, "Nombre: ");
        int edad = leerEntero(scanner, "Edad: ");
        String puesto = leerTexto(scanner, "Puesto: ");

        empleados.add(new Empleado(nombre, edad, puesto));
        System.out.println("Empleado agregado correctamente.");
    }

    private static void editarEmpleado(Scanner scanner, List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados para editar.");
            return;
        }

        listarEmpleados(empleados);
        int indice = leerEntero(scanner, "Numero de empleado a editar: ") - 1;

        if (indice < 0 || indice >= empleados.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        Empleado empleado = empleados.get(indice);
        String nuevoNombre = leerTexto(scanner, "Nuevo nombre: ");
        int nuevaEdad = leerEntero(scanner, "Nueva edad: ");
        String nuevoPuesto = leerTexto(scanner, "Nuevo puesto: ");

        empleado.setNombre(nuevoNombre);
        empleado.setEdad(nuevaEdad);
        empleado.setPuesto(nuevoPuesto);

        System.out.println("Empleado actualizado correctamente.");
    }

    private static void eliminarEmpleado(Scanner scanner, List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados para eliminar.");
            return;
        }

        listarEmpleados(empleados);
        int indice = leerEntero(scanner, "Numero de empleado a eliminar: ") - 1;

        if (indice < 0 || indice >= empleados.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        Empleado eliminado = empleados.remove(indice);
        System.out.println("Empleado eliminado: " + eliminado.getNombre());
    }

    private static void hacerTrabajarEmpleado(Scanner scanner, List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados para trabajar.");
            return;
        }

        listarEmpleados(empleados);
        int indice = leerEntero(scanner, "Numero de empleado para trabajar: ") - 1;

        if (indice < 0 || indice >= empleados.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        empleados.get(indice).trabajar();
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Debe ingresar un numero.");
            }
        }
    }

    private static String leerTexto(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("El texto no puede estar vacio.");
        }
    }
}