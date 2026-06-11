package desafio;

public class Usuario {
    private String nombre;
    private String dni;

    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void mostrarDatos() {
        System.out.println("Usuario{nombre='" + nombre + "', dni='" + dni + "'}");
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
}
