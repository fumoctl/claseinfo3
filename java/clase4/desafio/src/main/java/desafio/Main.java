package desafio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Bibliotecario bibliotecario = new Bibliotecario("Laura Perez", "30111222", biblioteca);
        inicializarDatos(biblioteca, bibliotecario);

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    registrarLibro(scanner, bibliotecario);
                    break;
                case "2":
                    eliminarLibro(scanner, biblioteca, bibliotecario);
                    break;
                case "3":
                    biblioteca.listarLibrosDisponibles();
                    break;
                case "4":
                    buscarLibroPorTitulo(scanner, biblioteca);
                    break;
                case "5":
                    registrarLector(scanner, biblioteca);
                    break;
                case "6":
                    realizarPrestamo(scanner, biblioteca);
                    break;
                case "7":
                    devolverLibro(scanner, biblioteca);
                    break;
                case "8":
                    listarUsuarios(biblioteca);
                    break;
                case "0":
                    salir = true;
                    System.out.println("Saliendo del sistema de biblioteca...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static void inicializarDatos(Biblioteca biblioteca, Bibliotecario bibliotecario) {
        biblioteca.agregarUsuario(bibliotecario);
        biblioteca.agregarUsuario(new Lector("Juan Gomez", "40999888"));
        biblioteca.agregarUsuario(new Lector("Sofia Diaz", "42777666"));

        bibliotecario.registrarLibro(new Libro("Clean Code", "Robert C. Martin", "9780132350884"));
        bibliotecario.registrarLibro(new Libro("Effective Java", "Joshua Bloch", "9780134685991"));
        bibliotecario.registrarLibro(new Libro("Design Patterns", "GoF", "9780201633610"));
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
        System.out.println("1. Registrar libro");
        System.out.println("2. Eliminar libro");
        System.out.println("3. Listar libros disponibles");
        System.out.println("4. Buscar libro por titulo");
        System.out.println("5. Registrar lector");
        System.out.println("6. Realizar prestamo");
        System.out.println("7. Devolver libro");
        System.out.println("8. Listar usuarios");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static void registrarLibro(Scanner scanner, Bibliotecario bibliotecario) {
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine().trim();
        System.out.print("Autor: ");
        String autor = scanner.nextLine().trim();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine().trim();

        bibliotecario.registrarLibro(new Libro(titulo, autor, isbn));
    }

    private static void eliminarLibro(Scanner scanner, Biblioteca biblioteca, Bibliotecario bibliotecario) {
        System.out.print("Ingrese el titulo del libro a eliminar: ");
        String titulo = scanner.nextLine().trim();
        Libro libro = biblioteca.buscarLibroPorTitulo(titulo);

        if (libro == null) {
            System.out.println("No se encontro un libro con ese titulo.");
            return;
        }
        bibliotecario.eliminarLibro(libro);
    }

    private static void buscarLibroPorTitulo(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Ingrese el titulo a buscar: ");
        String titulo = scanner.nextLine().trim();
        Libro libro = biblioteca.buscarLibroPorTitulo(titulo);

        if (libro == null) {
            System.out.println("No se encontro un libro con ese titulo.");
            return;
        }
        libro.mostrarInfo();
    }

    private static void registrarLector(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Nombre del lector: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("DNI del lector: ");
        String dni = scanner.nextLine().trim();

        biblioteca.agregarUsuario(new Lector(nombre, dni));
        System.out.println("Lector registrado correctamente.");
    }

    private static void realizarPrestamo(Scanner scanner, Biblioteca biblioteca) {
        Lector lector = obtenerLectorPorDni(scanner, biblioteca);
        if (lector == null) {
            return;
        }

        System.out.print("Titulo del libro a prestar: ");
        String titulo = scanner.nextLine().trim();
        Libro libro = biblioteca.buscarLibroPorTitulo(titulo);
        if (libro == null) {
            System.out.println("No se encontro un libro con ese titulo.");
            return;
        }

        lector.realizarPrestamo(libro);
    }

    private static void devolverLibro(Scanner scanner, Biblioteca biblioteca) {
        Lector lector = obtenerLectorPorDni(scanner, biblioteca);
        if (lector == null) {
            return;
        }

        System.out.print("Titulo del libro a devolver: ");
        String titulo = scanner.nextLine().trim();
        Libro libro = biblioteca.buscarLibroPorTitulo(titulo);
        if (libro == null) {
            System.out.println("No se encontro un libro con ese titulo.");
            return;
        }

        lector.devolverLibro(libro);
    }

    private static Lector obtenerLectorPorDni(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("DNI del lector: ");
        String dni = scanner.nextLine().trim();

        for (Usuario usuario : biblioteca.getUsuarios()) {
            if (usuario instanceof Lector && usuario.getDni().equals(dni)) {
                return (Lector) usuario;
            }
        }

        System.out.println("No existe un lector registrado con ese DNI.");
        return null;
    }

    private static void listarUsuarios(Biblioteca biblioteca) {
        System.out.println("Usuarios registrados:");
        for (Usuario usuario : biblioteca.getUsuarios()) {
            usuario.mostrarDatos();
        }
    }
}