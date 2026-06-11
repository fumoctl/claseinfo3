package ej1;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Juan Lopez", 20, "Ingenieria en Sistemas");
        Empleado empleado = new Empleado("Ana Perez", 30, "Desarrolladora");

        System.out.println("Informacion del Estudiante:");
        estudiante.mostrar();
        estudiante.mostrarCarrera();

        System.out.println("\nInformacion del Empleado:");
        empleado.mostrar();
        empleado.mostrarPuesto();
        empleado.trabajar();

        System.out.println("\nActualizando informacion estudiante...");
        estudiante.setNombre("Juan Carlos Santana Rodriguez");
        estudiante.setEdad(32);
        estudiante.setCarrera("Ingenieria Informatica");
        System.out.println("\nActualizando informacion empleado...");
        empleado.setNombre("Ana Maria Perez");
        empleado.setEdad(31);
        empleado.setPuesto("Project Manager");

        System.out.println("\nInformacion actualizada del Estudiante:");
        estudiante.mostrar();
        estudiante.mostrarCarrera();

        System.out.println("\nInformacion actualizada del Empleado:");
        empleado.mostrar();
        empleado.mostrarPuesto();
        empleado.trabajar();
    }
}