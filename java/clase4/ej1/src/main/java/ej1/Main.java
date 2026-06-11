package ej1;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Juan Lopez", 20, "Ingenieria en Sistemas");

        estudiante.mostrar();
        estudiante.mostrarCarrera();

        estudiante.setNombre("Juan Carlos Santana Rodriguez");
        estudiante.setEdad(32);
        estudiante.setCarrera("Ingenieria Informatica");
        estudiante.mostrar();
        estudiante.mostrarCarrera();
    }
}