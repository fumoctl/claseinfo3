package ej1;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan Lopez", 20);

        p1.mostrar();

        p1.setNombre("Juan Carlos Santana Rodriguez");
        p1.setEdad(32);
        p1.mostrar();
    }
}